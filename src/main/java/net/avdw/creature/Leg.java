package net.avdw.creature;

import net.avdw.creature.codegen.Describe;

@Describe
public class Leg {
    String side;
    Foot foot;

    public Leg(String side, Foot foot) {
        this.side = side;
        this.foot = foot;
    }
}
