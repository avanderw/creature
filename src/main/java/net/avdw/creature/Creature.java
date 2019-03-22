package net.avdw.creature;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.pmw.tinylog.Logger;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Creature {
    public Body body;

    final String description;

    @Inject
    Creature(Body body, @Named("creature-template") String template) {
        this.body = body;

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(template, new TemplateParserContext());
        description = expression.getValue(this, String.class);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
