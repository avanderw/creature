package net.avdw.creature;

import com.google.gson.Gson;
import com.google.inject.Inject;
import net.avdw.creature.codegen.Describe;

public class Creature {
    @Describe
    Body body;

    @Inject
    Creature(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
