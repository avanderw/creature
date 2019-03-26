package net.avdw.creature;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import net.avdw.creature.tail.TailModule;
import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class BodyModule extends AbstractModule {
    private EnumeratedDistribution<String> templates;

    @Override
    protected void configure() {
        install(new HeadModule());
        install(new HeartModule());
        install(new SkinModule());
        install(new ArmModule());
        install(new LegModule());
        install(new WingModule());
        install(new TailModule());

        templates = templates();
    }

    @Provides
    @Named("body-template")
    String template() {
        return templates.sample();
    }

    private EnumeratedDistribution<String> templates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
//        descriptions.add(new Pair<>("todo:classifier #{heart.description} #{skin.description} #{legs.description}#{arms.description}#{heads.description}#{wings.description}#{tails.description}", 1 / denominator));
        descriptions.add(new Pair<>("#{tails.description} #{heart.description}", 1 / denominator));
        return new EnumeratedDistribution<>(descriptions);
    }
}
