package net.avdw.creature;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LegModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Describer.class).annotatedWith(Names.named("legs")).to(LegsDescriber.class);
        bind(Describer.class).annotatedWith(Names.named("leg")).to(LegDescriber.class);
    }

    @Provides
    List<Leg> legs(Foot foot) {
        int[] legSets = new int[]{0,1,2,3,4};
        double[] probabilities = new double[]{.2,.4,.1,.2,.1};
        EnumeratedIntegerDistribution legSetDistribution = new EnumeratedIntegerDistribution(legSets, probabilities);
        List<Leg> legs = new ArrayList<>();
        IntStream.range(0, legSetDistribution.sample()).forEach(i-> {
            legs.add(new Leg("left", foot, ""));
            legs.add(new Leg("right", foot, ""));
        });
        return legs;
    }

    @Provides
    @Named("legs-description-template")
    String legsTemplate(@Named("legs-description-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides
    @Singleton
    @Named("legs-description-templates")
    EnumeratedDistribution<String> legsTemplates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("legs", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }

    @Provides
    @Named("leg-description-template")
    String legTemplate(@Named("leg-description-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides
    @Singleton
    @Named("leg-description-templates")
    EnumeratedDistribution<String> legTemplates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("leg", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }
}
