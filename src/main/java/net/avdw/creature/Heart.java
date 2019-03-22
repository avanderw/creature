package net.avdw.creature;

import net.avdw.creature.codegen.Describe;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Describe
class Heart {

    final String type;
    final public String adjective;
    final public String description;

    Heart(String type, String adjective, String template) {
        this.type = type;
        this.adjective = adjective;

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(template, new TemplateParserContext());
        description = expression.getValue(this, String.class);
    }
}
