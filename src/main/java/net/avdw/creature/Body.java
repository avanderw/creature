package net.avdw.creature;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import net.avdw.creature.codegen.Describe;
import net.avdw.creature.tail.Tails;
import org.pmw.tinylog.Logger;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Describe
public class Body {
    public Heads heads;

    public Arms arms;

    public Wings wings;

    public Legs legs;


    public Tails tails;

    public Skin skin;

    public Heart heart;

    public String description;

    @Inject
    public Body(@Named("body-template") String template,Heads heads, Arms arms, Wings wings, Legs legs, Tails tails, Skin skin, Heart heart) {
        this.heads = heads;
        this.arms = arms;
        this.wings = wings;
        this.legs = legs;
        this.tails = tails;
        this.skin = skin;
        this.heart = heart;

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(template, new TemplateParserContext());
        description = expression.getValue(this, String.class);
        Logger.trace(description);
    }
}
