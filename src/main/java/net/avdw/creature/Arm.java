package net.avdw.creature;

import net.avdw.creature.codegen.Describe;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Describe
public class Arm {
    private final String side;
    Hand hand;
    public final String description;

    public Arm(String side, Hand hand, String template) {

        this.side = side;
        this.hand = hand;

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(template, new TemplateParserContext());
        description = expression.getValue(this, String.class);
    }
}
