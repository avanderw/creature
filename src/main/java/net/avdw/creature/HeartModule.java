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

public class HeartModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Describer.class).annotatedWith(Names.named("heart")).to(HeartDescriber.class);
    }

    @Provides
    @Named("heart-description-template")
    String template(@Named("heart-description-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides
    @Singleton
    @Named("heart-description-templates")
    EnumeratedDistribution<String> templates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("a large green heart", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }

    @Provides
    Heart heart() {
        List<Pair<Heart, Double>> hearts = new ArrayList<>();
        hearts.add(new Pair<>(new Heart("Bionic", "artificial"), 0.4));
        hearts.add(new Pair<>(new Heart("Metallic", "metallic"), 0.1));
        hearts.add(new Pair<>(new Heart("Cybernetic", "electronic"), 0.3));
        hearts.add(new Pair<>(new Heart("Tissue", "flesh"), 0.2));
        EnumeratedDistribution<Heart> distribution = new EnumeratedDistribution<>(hearts);
        return distribution.sample();
    }}
