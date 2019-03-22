package net.avdw.creature;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class TailModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Describer.class).annotatedWith(Names.named("tails")).to(TailsDescriber.class);
        bind(Describer.class).annotatedWith(Names.named("tail")).to(TailDescriber.class);
    }

    @Provides
    @Named("tails-adjective-template")
    String tailsTemplate(@Named("tails-adjective-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides
    @Singleton
    @Named("tails-adjective-templates")
    EnumeratedDistribution<String> tailsTemplates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("tails", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }

    @Provides
    @Named("tail-adjective-template")
    String tailTemplate(@Named("tail-adjective-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides
    @Singleton
    @Named("tail-adjective-templates")
    EnumeratedDistribution<String> tailTemplates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("tail", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }
}
