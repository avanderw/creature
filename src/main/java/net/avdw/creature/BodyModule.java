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

public class BodyModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new HeadModule());
        install(new HeartModule());
        install(new SkinModule());
        install(new ArmModule());
        install(new LegModule());
        install(new WingModule());
        install(new TailModule());

        bind(Describer.class).annotatedWith(Names.named("body")).to(BodyDescriber.class);
    }

    @Provides
    @Named("body-adjective-template")
    String template(@Named("body-adjective-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides
    @Singleton
    @Named("body-adjective-templates")
    EnumeratedDistribution<String> templates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("todo:classifier #{heart}#{skin}Some other text. #{legs}#{arms}#{heads}#{wings}#{tails}", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }
}
