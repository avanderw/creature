package net.avdw.creature;

public enum WingType {
    ACTIVE_SOARING("Long and narrow. Excellent for flying without flapping over water as long as wind currents are favorable."),
    PASSIVE_SOARING("Long and broad ending in long primary feathers with wide gaps in between. These slots help the creature take advantage of columns of rising hot air, allowing it to soar without reliable wind currents."),
    ELLIPTICAL("Optimised for bursts of fast, tightly controlled flight. Excellent at taking off quickly, maneuvering through branches and avoiding predators. Ordinary flight is slow and usually requires flapping."),
    HIGH_SPEED("Medium-long and narrow, optimised for sustained speed."),
    HOVERING("Small relative to body size. Excellent for tightly controlled flight and hovering. Articulates mostly at the shoulder rather than the wrist.");

    private String description;

    WingType(String description) {

        this.description = description;
    }
}
