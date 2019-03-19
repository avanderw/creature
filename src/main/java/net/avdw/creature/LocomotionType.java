package net.avdw.creature;

public enum LocomotionType {
        GLIDE("can glide when dropping from heights"),
        MARATHON("can run for enormous distances without fatigue"),
        SPRINT("capable of short bursts of great speed"),
        JUMP("hopping (as a mode of travel) or single leap (for attacks)"),
        BURROW("gofer-like means of travel"),
        TELEPORT("line of sight, to several set locations, or anywhere at will"),
        SWIM("might also breathe water, resistant to pressures"),
        BRACHIATE("must have canopy of tree limbs or overhead handholds"),
        SUMMON_MOUNT("steed, avian or other, comes from distance or appears"),
        FOLLOW_RIVER("enter stream at one point, then (instantly?) exit at another"),
        GATE("can teleport from like points (trees, monoliths, pools, coffee shops, etc)"),
        TUMBLE("can either dry up and drift (tumbleweed), or roll end over end"),
        STEP_MULTIPLY("each step doubles in distance (2′, 4′, 8′, and so on)"),
        WATER_WALK("can walk (or skim) across liquids at will"),
        LAND_SURF("rides a small wave of earth that temporarily liquefies"),
        FLY("full flight capability, with or without wings"),
        SPIRIT_LIKE("can become ghostly and float along, through solid objects"),
        ELECTRICAL("can travel along conducting materials or as a bolt of lightning"),
        HOST("enter another creature, emerge later (might not control creature)");

    private String description;

        LocomotionType(String description) {

            this.description = description;
        }
}
