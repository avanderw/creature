package net.avdw.creature;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.lang.String;
import javax.annotation.Generated;
import org.pmw.tinylog.Logger;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Generated(
        value = "class net.avdw.creature.codegen.GenerateDescribers",
        date = "Fri Mar 22 13:25:09 CAT 2019"
)
class HeartsDescriber implements Describer {
    String template;

    @Inject
    HeartsDescriber(@Named("hearts-description-template") String template) {
        this.template = template;
    }

    public String describe() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(template, new TemplateParserContext());
        String description = expression.getValue(this, String.class);
        Logger.debug(description);
        return description;
    }
}
