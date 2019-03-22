package net.avdw.creature;

import net.avdw.creature.codegen.Describe;

@Describe
public class Heart {

    String type;
    String description;

    public Heart(String type, String description) {
        this.type = type;
        this.description = description;

    }
}
