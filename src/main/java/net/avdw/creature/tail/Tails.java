package net.avdw.creature.tail;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.commons.text.WordUtils;

import java.util.List;

public class Tails {
    public List<Tail> tails;
    public String description;

    @Inject
    Tails(List<Tail> tails) {
        this.tails = tails;
    }

    @Inject
    public void setDescription(@Named("tails.description") String description) {
        this.description = description;
    }

    public String uncapitalize(String string) {
        return WordUtils.uncapitalize(string);
    }
}
