package net.avdw.creature;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class BodyModule extends AbstractModule {
    @Provides
    @Singleton
    @Named("body-descriptions")
    EnumeratedDistribution<String> descriptionDistribution() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("#{classifier}#{heart}#{skin}Some other text. #{legs}#{arms}#{heads}#{wings}#{tails}", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }
}
