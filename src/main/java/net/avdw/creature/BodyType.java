package net.avdw.creature;

public enum BodyType {
        MAN("roughly anthropomorphic"),
        SLUG("large, medium or small as desired"),
        CENTAUR("humanoid from the waist up, animal below"),
        QUADRUPED_SMALL("an animal like a cat, dog, weasel, wolf or rat"),
        BIRDLIKE("large, medium or small as desired"),
        SERPENTINE("something like a snake, eel or worm"),
        RAY("flat, like a manta ray; not necessarily aquatic"),
        FISH("not necessarily aquatic"),
        PLANT("rooted or ambulatory"),
        MAN_ANIMAL("roughly anthropomorphic body, but animal-headed"),
        BUG("spider, scorpion, wasp, mantis, moth, tick or crustacean"),
        BLOB("an amorphous mass of some organic material"),
        BALLOON("a sac, filled with gas or liquid"),
        OCTOPUS("not necessarily aquatic"),
        MAN_SNAKE("half humanoid, half serpent"),
        VINE("free-roaming or rooted"),
        QUADRUPED_LARGE("an animal like a bear, horse, deer, goat, puma or bull"),
        MAN_HUGE("roughly anthropomorphic, but hulking"),
        SNAIL("large, medium or small as desired"),
        STARFISH("not necessarily aquatic");

    private String desciption;

    BodyType(String desciption) {

        this.desciption = desciption;
    }
}
