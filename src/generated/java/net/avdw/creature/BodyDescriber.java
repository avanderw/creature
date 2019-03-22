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
class BodyDescriber implements Describer {
    String template;

    Describer headsDescriber;

    Describer armsDescriber;

    Describer wingsDescriber;

    Describer legsDescriber;

    Describer tailsDescriber;

    Describer skinDescriber;

    Describer heartDescriber;

    @Inject
    BodyDescriber(@Named("body-description-template") String template,
            @Named("heads") Describer headsDescriber, @Named("arms") Describer armsDescriber,
            @Named("wings") Describer wingsDescriber, @Named("legs") Describer legsDescriber,
            @Named("tails") Describer tailsDescriber, @Named("skin") Describer skinDescriber) {
        this.template = template;
        this.headsDescriber = headsDescriber;
        this.armsDescriber = armsDescriber;
        this.wingsDescriber = wingsDescriber;
        this.legsDescriber = legsDescriber;
        this.tailsDescriber = tailsDescriber;
        this.skinDescriber = skinDescriber;
    }

    public String getHeads() {
        return headsDescriber.describe();
    }

    public String getArms() {
        return armsDescriber.describe();
    }

    public String getWings() {
        return wingsDescriber.describe();
    }

    public String getLegs() {
        return legsDescriber.describe();
    }

    public String getTails() {
        return tailsDescriber.describe();
    }

    public String getSkin() {
        return skinDescriber.describe();
    }


    public String describe() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(template, new TemplateParserContext());
        String description = expression.getValue(this, String.class);
        Logger.debug(description);
        return description;
    }
}
