package net.avdw.creature;

import net.avdw.creature.codegen.Describe;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Describe
public class Leg {
    String side;
    Foot foot;
    final public String description;

    public Leg(String side, Foot foot, String template) {
        this.side = side;
        this.foot = foot;

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(template, new TemplateParserContext());
        description = expression.getValue(this, String.class);
    }
}
