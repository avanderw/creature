package net.avdw.creature;

import com.google.inject.Inject;

@Deprecated
public class DescriptionContext {
    final CreatureNamer creatureNamer;
    private BodyDescriber bodyDescriber;

    @Inject
    public DescriptionContext(CreatureNamer creatureNamer, BodyDescriber bodyDescriber) {
        this.creatureNamer = creatureNamer;
        this.bodyDescriber = bodyDescriber;
    }

    public String getName() {
        return creatureNamer.name();
    }

    public String getBody() {
        return bodyDescriber.describe();
    }
}
