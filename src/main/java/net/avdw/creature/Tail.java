package net.avdw.creature;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import net.avdw.creature.codegen.Describe;

@Describe
public class Tail {
    private String type;
    public String adjective;
    public String description;

    @Inject
    public Tail(TailType type) {
        this.type = type.name;
        this.adjective = type.adjective;
    }

    @Inject
    public void setDescription(@Named("tail.description") String description) {
        this.description = description;
    }
}
