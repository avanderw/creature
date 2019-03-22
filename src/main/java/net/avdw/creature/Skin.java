package net.avdw.creature;

import net.avdw.creature.codegen.Describe;

@Describe
public class Skin {
    final String type;
    String description;

    Skin(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
