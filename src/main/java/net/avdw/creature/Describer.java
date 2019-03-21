package net.avdw.creature;

import com.google.inject.Inject;
import org.pmw.tinylog.Logger;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Deprecated
public class Describer {
    final DescriptionContext descriptionContext;

    @Inject
    public Describer(DescriptionContext descriptionContext) {
        this.descriptionContext = descriptionContext;
    }

    String describe(String template) {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(template, new TemplateParserContext());
        String description = expression.getValue(descriptionContext, String.class);
        Logger.debug(description);
        return description;
    }
}
