package net.avdw.creature;

import com.google.inject.Inject;
import net.avdw.creature.codegen.Describe;

import java.util.List;

@Describe
public class Body {
    @Describe
    List<Head> heads;

    @Describe
    List<Arm> arms;

    @Describe
    List<Wing> wings;

    @Describe
    List<Leg> legs;

    @Describe
    List<Tail> tails;

    @Describe
    Skin skin;

    @Describe
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
}
