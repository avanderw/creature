package net.avdw.creature;

import com.google.inject.Inject;

public class Creature {
    Body body;

    @Inject
    Creature(Body body) {
        this.body = body;
    }

    public String toString() {
        return String.format("body={%s}", body);
    }
}
