package net.avdw.creature;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import net.avdw.creature.codegen.Describe;
import org.apache.commons.text.WordUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Describe
public class Tail {
    private String type;
    public String adjective;
    public String description;

    @Inject
    public Tail(TailType type, @Named("tail.template") String template) {
        this.type = type.name;
        this.adjective = type.adjective;

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(template, new TemplateParserContext());
        description = expression.getValue(this, String.class);
    }

}
