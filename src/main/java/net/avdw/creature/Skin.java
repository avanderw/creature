package net.avdw.creature;

import net.avdw.creature.codegen.Describe;

@Describe
public class Skin {
    public final String type;
    public final String description;

    Skin(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
