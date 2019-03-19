package net.avdw.creature;

public enum TraitType {
    Death_change("fades, liquefies, petrifies, reverts or explodes upon death"),
    Animate_shadow("creature’s shadow becomes its agent"),
    Commune_with_dead("can speak with dead, summon ghosts"),
    Telepathic("one or two way communication"),
    Multi_headed("multiple sentient heads"),
    Secondary_form("assume a single alternate body/shape"),
    Shape_shift("alter body to any shape desired"),
    Undead("monster is undead (zombie or ghoul-like)"),
    Grow_Shrink("get larger or smaller at will (either or both)"),
    Iron_shift("skin becomes flexible metal, half mobility"),
    Amorphous_shift("become a fluid blob at will"),
    Spirit_shift("become wraithlike at will, perhaps controls undead"),
    Luminescent_eyes("glowing, allows for night vision, easily spotted"),
    Skeletal("flesh/organs nonexistent or hidden within bone frame"),
    Poison_flesh("flesh is toxic if consumed"),
    Body_switch("can swap bodies with opponent, temporary or permanent"),
    Animated_inorganic("active statue, machine or toy"),
    Mental_control("can command small creature(s), one type or multiple");

    private String description;

    TraitType(String description) {

        this.description = description;
    }
}
