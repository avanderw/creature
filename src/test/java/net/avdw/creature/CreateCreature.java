package net.avdw.creature;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CreateCreature {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CreatureModule());
        System.out.println(injector.getInstance(Creature.class));
        System.out.println(injector.getInstance(Creature.class));
    }
}
