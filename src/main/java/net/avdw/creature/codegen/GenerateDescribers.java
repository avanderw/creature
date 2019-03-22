package net.avdw.creature.codegen;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.squareup.javapoet.*;
import net.avdw.creature.*;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.text.WordUtils;
import org.pmw.tinylog.Logger;
import org.reflections.Reflections;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.annotation.Generated;
import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class GenerateDescribers {
    public static void main(String[] args) {
        new Reflections("net.avdw.creature")
                .getTypesAnnotatedWith(Describe.class)
                .forEach(GenerateDescribers::createDescriber);

        new Reflections("net.avdw.creature")
                .getTypesAnnotatedWith(Describe.class)
                .forEach(GenerateDescribers::createListDescribers);
    }

    private static void createListDescribers(Class<?> aClass) {
        TypeSpec.Builder describer = createTypeBuilder(String.format("%ssDescriber", aClass.getSimpleName()));
        MethodSpec.Builder constructor = createConstructorBuilder(String.format("%ss", aClass.getSimpleName().toLowerCase()));

        describer.addMethod(constructor.build());
        describer.addMethod(describeMethod());
        writeToFile(describer.build());
    }

    private static void createDescriber(Class<?> aClass) {
        TypeSpec.Builder describer = createTypeBuilder(String.format("%sDescriber", aClass.getSimpleName()));
        MethodSpec.Builder constructor = createConstructorBuilder(aClass.getSimpleName().toLowerCase());

        FieldUtils.getFieldsListWithAnnotation(aClass, Describe.class).forEach(field -> {
            String fieldDescriberName = String.format("%sDescriber", field.getName());
            describer.addField(FieldSpec.builder(Describer.class, fieldDescriberName).build());
            constructor.addParameter(ParameterSpec.builder(Describer.class, fieldDescriberName)
                    .addAnnotation(AnnotationSpec.builder(Named.class).addMember("value", "$S", field.getName()).build())
                    .build());
            constructor.addStatement(String.format("this.%s = %s", fieldDescriberName, fieldDescriberName));
            describer.addMethod(MethodSpec.methodBuilder("get" + WordUtils.capitalize(field.getName()))
                    .addModifiers(Modifier.PUBLIC)
                    .returns(String.class)
                    .addStatement(String.format("return %s.describe()", fieldDescriberName))
                    .build());
        });

        describer.addMethod(constructor.build());
        describer.addMethod(describeMethod());
        writeToFile(describer.build());
    }

    private static void writeToFile(TypeSpec describer) {
        JavaFile javaFile = JavaFile.builder("net.avdw.creature", describer)
                .indent("    ")
                .build();
        try {
            javaFile.writeTo(new File("src/generated/java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static TypeSpec.Builder createTypeBuilder(String name) {
        return TypeSpec.classBuilder(name)
                .addAnnotation(AnnotationSpec.builder(Generated.class)
                        .addMember("value", "$S", GenerateDescribers.class.toString())
                        .addMember("date", "$S", new Date().toString())
                        .build())
                .addSuperinterface(Describer.class)
                .addField(FieldSpec.builder(String.class, "template").build());
    }

    private static MethodSpec.Builder createConstructorBuilder(String name) {
        return MethodSpec.constructorBuilder()
                .addAnnotation(Inject.class)
                .addParameter(ParameterSpec.builder(String.class, "template")
                        .addAnnotation(AnnotationSpec.builder(Named.class).addMember("value", "$S", String.format("%s-description-template", name)).build())
                        .build())
                .addStatement("this.template = template");
    }

    private static MethodSpec describeMethod() {
        return MethodSpec.methodBuilder("describe")
                .addModifiers(Modifier.PUBLIC)
                .returns(String.class)
                .addStatement("$T expressionParser = new $T()", ExpressionParser.class, SpelExpressionParser.class)
                .addStatement("$T expression = expressionParser.parseExpression(template, new $T())", Expression.class, TemplateParserContext.class)
                .addStatement("String description = expression.getValue(this, String.class)")
                .addStatement("$T.debug(description)", Logger.class)
                .addStatement("return description")
                .build();
    }
}
