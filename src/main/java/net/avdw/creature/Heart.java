package net.avdw.creature;

import net.avdw.creature.codegen.Describe;

@Describe
public class Heart {

    String type;
    String adjective;

    public Heart(String type, String adjective) {
        this.type = type;
        this.adjective = adjective;

    }
}
