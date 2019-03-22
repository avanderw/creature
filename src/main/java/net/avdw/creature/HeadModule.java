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

public class HeadModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Describer.class).annotatedWith(Names.named("heads")).to(HeadsDescriber.class);
        bind(Describer.class).annotatedWith(Names.named("head")).to(HeadDescriber.class);
    }

    @Provides
    @Named("heads-description-template")
    String headsTemplate(@Named("heads-description-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides
    @Singleton
    @Named("heads-description-templates")
    EnumeratedDistribution<String> headsTemplates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("many heads", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }

    @Provides
    @Named("head-description-template")
    String headTemplate(@Named("head-description-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides
    @Singleton
    @Named("head-description-templates")
    EnumeratedDistribution<String> headTemplates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("a large green head", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }
}
