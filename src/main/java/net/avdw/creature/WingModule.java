package net.avdw.creature;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WingModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    @Singleton
    EnumeratedIntegerDistribution numWingPairsDistribution() {
        int[] counts = new int[]{0, 1, 2, 3};
        double[] probabilities = new double[]{.1, .5, .1, .3};
        return new EnumeratedIntegerDistribution(counts, probabilities);
    }

    @Provides
    @Singleton
    EnumeratedDistribution<Wing> wingTypeDistribution() {
        float denominator = 5f;
        List<Pair<Wing, Double>> wings = new ArrayList<>();
        wings.add(new Pair<>(new Wing(WingType.ACTIVE_SOARING), 1. / denominator));
        wings.add(new Pair<>(new Wing(WingType.PASSIVE_SOARING), 1. / denominator));
        wings.add(new Pair<>(new Wing(WingType.ELLIPTICAL), 1. / denominator));
        wings.add(new Pair<>(new Wing(WingType.HIGH_SPEED), 1. / denominator));
        wings.add(new Pair<>(new Wing(WingType.HOVERING), 1. / denominator));
        return new EnumeratedDistribution<>(wings);
    }

    @Provides
    List<Wing> wings(EnumeratedIntegerDistribution numWings, EnumeratedDistribution<Wing> wingType) {
        List<Wing> wings = new ArrayList<>();
        IntStream.rangeClosed(0, numWings.sample()).forEach(i -> {
            Wing wing = wingType.sample();
            wings.add(wing);
            wings.add(wing);
        });
        return wings;
    }
}
