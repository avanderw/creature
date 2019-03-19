package net.avdw.creature;

public enum AttackType {

    Mind_assault("can cause fear, damage, intense pleasure or apathy"),
    Organic_projectile("explosive or ballistic seeds, flesh clumps, teeth"),
    Acid("spat, squirted from orifice, oozed from skin or other"),
    Lignify("can turn opponent into a tree, temporary or permanent"),
    Conjure("can summon creature(s), random or always same type"),
    Pyrotechnic("project, summon or breath flames (streams, shapes or balls)"),
    Electricity("arcs of electrical energy, or summoned lightning from above"),
    Gas("exhaled or sprayed from orifice, blinding, noxious, paralyzing or other"),
    Venomous_bite("fangs, external mandibles or tongue , poisons or paralyzes"),
    Venomous_claws("poisons or paralyzes"),
    Multiply("can quickly clone self"),
    Thorns("projected or used in bodily contact attacks"),
    Paralytic("by touch, beams or mental attack"),
    Sonic_shriek("harmful or stunning noise"),
    Suggestion("spoken or mental projection"),
    Constriction("crushing grip with limbs, tail or other appendage"),
    Sleep("can stun or knock opponent unconscious by some means"),
    Spirit_leech("can drain life energy (by touch, gaze, proximity, etc)"),
    Frosty_breath("can exhale air at extremely low (damaging) temperatures"),
    Shape_shift_foe("change enemy into alternate form, random or specific");

    private String description;

    AttackType(String description) {

        this.description = description;
    }
}
