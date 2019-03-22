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

public class ArmModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Describer.class).annotatedWith(Names.named("arms")).to(ArmsDescriber.class);
        bind(Describer.class).annotatedWith(Names.named("arm")).to(ArmDescriber.class);
    }

    @Provides
    @Named("arms-description-template")
    String armsTemplate(@Named("arms-description-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides
    @Singleton
    @Named("arms-description-templates")
    EnumeratedDistribution<String> armsTemplates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("arms description", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }

    @Provides
    @Named("arm-description-template")
    String armTemplate(@Named("arm-description-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides
    @Singleton
    @Named("arm-description-templates")
    EnumeratedDistribution<String> armTemplates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("arm description", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }
}
