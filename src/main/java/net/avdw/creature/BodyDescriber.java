package net.avdw.creature;

import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.pmw.tinylog.Logger;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.inject.Inject;
import javax.inject.Named;

public class BodyDescriber {
    private EnumeratedDistribution<String> bodyDescriptions;

    @Inject
    BodyDescriber(@Named("body-descriptions") EnumeratedDistribution<String> bodyDescriptions) {
        this.bodyDescriptions = bodyDescriptions;
    }

    public String getHeads() {
        return "Heads. ";
    }

    public String getWings() {
        return "Wings. ";
    }

    public String getTails() {
        return "Tails. ";
    }

    public String getArms() {
        return "Arms. ";
    }

    public String getLegs() {
        if (Math.random() < .5) {
            return "Legs. ";
        } else {
            return "";
        }
    }

    public String getHeart() {
        return "Heart. ";
    }

    public String getSkin() {
        return "Skin. ";
    }

    public String getClassifier() {
        return "Body class. ";
    }

    String describe() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(bodyDescriptions.sample(), new TemplateParserContext());
        String description = expression.getValue(this, String.class);
        Logger.debug(description);
        return description;
    }
}
