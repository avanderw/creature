package net.avdw.creature.codegen;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import net.avdw.creature.Creature;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.text.WordUtils;
import org.pmw.tinylog.Logger;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.annotation.Generated;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class GenerateDescribers {
    public static void main(String[] args) {
        TypeSpec.Builder describer = TypeSpec.classBuilder("CreatureDescriber")
                .addAnnotation(AnnotationSpec.builder(Generated.class)
                        .addMember("value", "$S", GenerateDescribers.class.toString())
                        .addMember("date", "$S", new Date().toString())
                        .build());

        FieldUtils.getFieldsListWithAnnotation(Creature.class, Describe.class).forEach(field -> {
            describer.addMethod(MethodSpec.methodBuilder("get" + WordUtils.capitalize(field.getName()))
                    .returns(String.class)
                    .addStatement(String.format("return %sDescriber.describe()", field.getName()))
                    .build());
        });

        describer.addMethod(MethodSpec.methodBuilder("describe")
                .returns(String.class)
                .addStatement("$T expressionParser = new $T()", ExpressionParser.class, SpelExpressionParser.class)
                .addStatement("$T expression = expressionParser.parseExpression(template, new $T())", Expression.class, TemplateParserContext.class)
                .addStatement("String description = expression.getValue(this, String.class)")
                .addStatement("$T.debug(description)", Logger.class)
                .addStatement("return description")
                .build());

        JavaFile javaFile = JavaFile.builder("net.avdw.creature", describer.build())
                .indent("    ")
                .build();
        try {
            javaFile.writeTo(new File("src/generated/java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
