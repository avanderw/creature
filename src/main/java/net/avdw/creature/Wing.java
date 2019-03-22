package net.avdw.creature;

import net.avdw.creature.codegen.Describe;

@Describe
public class Wing {
    private final WingType shape;


    public Wing(WingType shape) {
        this.shape = shape;
    }
}
