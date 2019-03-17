package net.avdw.creature;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CreatureModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    List<Arm> arms() {
        List<Arm> arms =new ArrayList<>();
        IntStream.range(0, new Random().nextInt(8)).forEach(i-> arms.add(new Arm()));
        return arms;
    }

    @Provides
    List<Head> heads() {
        List<Head> heads = new ArrayList<>();
        IntStream.range(0, new Random().nextInt(6) + 1).forEach(i-> heads.add(new Head()));
        return heads;
    }

    @Provides
    List<Leg> legs() {
        List<Leg> legs =new ArrayList<>();
        IntStream.range(0, new Random().nextInt(8)).forEach(i-> legs.add(new Leg()));
        return legs;
    }

    @Provides
    List<Tail> tails() {
        List<Tail> tail =new ArrayList<>();
        IntStream.range(0, new Random().nextInt(3)).forEach(i-> tail.add(new Tail()));
        return tail;
    }

    @Provides
    List<Wing> wings() {
        List<Wing> wings =new ArrayList<>();
        IntStream.range(0, new Random().nextInt(2)).forEach(i-> {
            wings.add(new Wing());
            wings.add(new Wing());
        });
        return wings;
    }

}
