package net.avdw.creature;

import com.google.inject.Inject;
import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.pmw.tinylog.Logger;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.inject.Named;

public class CreatureDescriber {
    private CreatureNamer creatureNamer;
    private EnumeratedDistribution<String> creatureDescriptions;
    private BodyDescriber bodyDescriber;

    @Inject
    CreatureDescriber(CreatureNamer creatureNamer, @Named("creature-descriptions") EnumeratedDistribution<String> creatureDescriptions, BodyDescriber bodyDescriber) {
        this.creatureNamer = creatureNamer;
        this.creatureDescriptions = creatureDescriptions;
        this.bodyDescriber = bodyDescriber;
    }

    public String getName() {
        return creatureNamer.name();
    }

    public String getBody() {
        return bodyDescriber.describe();
    }

    String describe() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(creatureDescriptions.sample(), new TemplateParserContext());
        String description = expression.getValue(this, String.class);
        Logger.debug(description);
        return description;
    }
}
