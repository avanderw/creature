package net.avdw.creature;

import com.google.inject.Inject;

import java.util.List;

public class Body {
    List<Head> heads;
    List<Arm> arms;
    List<Wing> wings;
    List<Leg> legs;
    List<Tail> tails;
    Skin skin;
    Heart heart;

    @Inject
    public Body(List<Head> heads, List<Arm> arms, List<Wing> wings, List<Leg> legs, List<Tail> tails, Skin skin, Heart heart) {
        this.heads = heads;
        this.arms = arms;
        this.wings = wings;
        this.legs = legs;
        this.tails = tails;
        this.skin = skin;
        this.heart = heart;
    }

    public String toString() {
        return String.format("skin={%s}, heart={%s}, heads={%s}, arms={%s}, wings={%s}, legs={%s}, tails=[%s}",
                skin, heart, heads, arms, wings, legs, tails);
    }
}
