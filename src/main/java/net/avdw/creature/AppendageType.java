package net.avdw.creature;

public enum AppendageType {
    Retractable_claws("allow for raking attacks and enhanced climbing"),
    Tentacles("in addition to (or instead of) other limbs, many or few"),
    Claws("allow for raking attacks and enhanced climbing"),
    Multiple_limbs("copies of limbs, spirit or flesh, perhaps differently sized"),
    Pseudopods("prehensile amoeboid extensions, can be extended/retracted"),
    Odd_tongue("prehensile, stinging, forked, extra long, or other"),
    Pistoning_limbs("jab forward with great velocity (jaws, arms, tongue, etc)"),
    Tail("prehensile, spiked, stinger-equipped, clubbed, swim-aiding, etc"),
    Fins("enhanced swimming"),
    Wings("bat, bird or insect, for full flight or wing-assisted leaps"),
    Hoofed("good for running, strong legs for pulling"),
    Webbed("enhanced swimming"),
    Plumes("colorful, perhaps retractable"),
    Snake_body("serpentine from the waist down"),
    Exostosis("exposed bony spurs in various places, useful for slicing"),
    Odd_aura("faintly radiating nimbus, at will or uncontrollably"),
    Large_hands("oversized, strong"),
    Parasites("creature is visibly infested with bug(s) or other thing(s)"),
    Whiskers("long, fine hairs for navigation in darkness"),
    Talons("hands and/or feet are actually falcon-like talons");

    private String description;

    AppendageType(String description) {

        this.description = description;
    }
}
