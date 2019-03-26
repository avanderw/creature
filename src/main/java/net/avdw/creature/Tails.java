package net.avdw.creature;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.commons.text.WordUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;

public class Tails {
    public List<Tail> tails;
    public String description;

    @Inject
    Tails(List<Tail> tails) {
        this.tails = tails;
        this.description = description;
    }

    @Inject
    public void setDescription(@Named("tails.description") String description) {
        this.description = description;
    }
}
