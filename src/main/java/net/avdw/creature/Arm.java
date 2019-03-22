package net.avdw.creature;

import net.avdw.creature.codegen.Describe;

@Describe
public class Arm {
    private final String side;
    Hand hand;

    public Arm(String side, Hand hand) {

        this.side = side;
        this.hand = hand;
    }
}
