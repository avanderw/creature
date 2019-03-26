package net.avdw.creature;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import org.apache.commons.math3.util.Pair;
import org.apache.commons.text.WordUtils;
import org.pmw.tinylog.Logger;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class TailModule extends AbstractModule {

    @Provides
    @Singleton
    @Named("num.tails")
    Integer numTails() {
        int[] counts = new int[]{0, 1, 2, 3};
        double[] probabilities = new double[]{1. / counts.length, 1. / counts.length, 1. / counts.length, 1. / counts.length};
        return new EnumeratedIntegerDistribution(counts, probabilities).sample();
    }

    @Provides
    List<Tail> tails(@Named("num.tails") Integer numTails, Provider<Tail> tail) {
        List<Tail> tails = new ArrayList<>();
        IntStream.range(0, numTails).forEach(i -> tails.add(tail.get()));
        return tails;
    }

    @Provides
    @Singleton
    TailType tailType() {
        double d = 5.;
        List<Pair<TailType, Double>> types = new ArrayList<>();
        types.add(new Pair<>(new TailType("Bionic", "bionic"), 1 / d));
        types.add(new Pair<>(new TailType("Spiked", "spiked"), 1 / d));
        types.add(new Pair<>(new TailType("Stub", "stub"), 1 / d));
        types.add(new Pair<>(new TailType("Bone", "ring of bones for protection"), 1 / d));
        types.add(new Pair<>(new TailType("Long", "long"), 1 / d));

        return new EnumeratedDistribution<>(types).sample();
    }

    @Provides
    @Singleton
    @Named("tails.description")
    String chooseTailsTemplate(TemplatePopulator populator, Tails tails, @Named("tails.templates") EnumeratedDistribution<String> templates) {
        return populator.populate(templates.sample(), tails);
    }

    @Provides
    @Singleton
    @Named("tail.description")
    String chooseTailTemplate(TemplatePopulator populator, Tail tail, @Named("tail.templates") EnumeratedDistribution<String> templates) {
        return populator.populate(templates.sample(), tail);
    }

    @Provides
    @Singleton
    @Named("tails.templates")
    EnumeratedDistribution<String> createTailsTemplates(@Named("num.tails") Integer numTails) {
        double denominator;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        switch (numTails) {
            case 0:
                denominator = 2d;
                descriptions.add(new Pair<>("", 1 / denominator));
                descriptions.add(new Pair<>("It seems that the creature had once tails. But alas no more.", 1 / denominator));
                break;
            case 1:
                denominator = 1d;
                descriptions.add(new Pair<>("#{tails[0].description}", 1 / denominator));
                descriptions.add(new Pair<>("#{tails[0].description} This #{tails[0].adjective} tail indicates emotions through the positioning and movement. It moves violently when the creature is happy and droops when it is sad.", 1 / denominator));
                descriptions.add(new Pair<>("Occasionally the tail can be seen brushing away flies and other biting insects.", 1 / denominator));
                descriptions.add(new Pair<>("At high speeds the #{tails[0].adjective} tail plays a crucial role in stabilising the creature. #{tails[0].description}", 1 / denominator));
                break;
            case 2:
                denominator = 1d;
                descriptions.add(new Pair<>("Mutations have left the creature with two tails. A glimpse at one of them reveals that #{uncapitalize(tails[0].description)}", 1 / denominator));
                descriptions.add(new Pair<>("The creature uses its tails in competition for resources and also as an ornament when competing for sexual partners.", 1 / denominator));
                break;
            case 3:
                denominator = 1d;
                descriptions.add(new Pair<>("The creature has three-tails. They all look to be similar; #{tails[0].description}", 1 / denominator));
                descriptions.add(new Pair<>("The tails play an important role in courtship displays.", 1 / denominator));
                descriptions.add(new Pair<>("These tails are used as a rudder, helping the creature steer and maneuver.", 1 / denominator));
                break;

            default:
                throw new UnsupportedOperationException();
        }
        return new EnumeratedDistribution<>(descriptions);
    }

    @Provides
    @Singleton
    @Named("tail.templates")
    EnumeratedDistribution<String> createTailTemplates() {
        double denominator = 5d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("The narrow, segmented tail, often carried in a characteristic forward curve over the back, ending with a venomous stinger.", 1 / denominator));
        descriptions.add(new Pair<>("A tail covered in free bony rings of dermal structures that make for a strong, flexible, and mobile appendix. This enables the creature to use the muscles along its tail to powerfully swing it.", 1 / denominator));
        descriptions.add(new Pair<>("The rings in the tail are fused together, making the tail resemble a single piece of rigid bone.", 1 / denominator));
        descriptions.add(new Pair<>("If the spikes were removed from the end of the tail, it would resemble a pestle.", 1 / denominator));
        descriptions.add(new Pair<>("The tail is surrounded by a flexible sheath of bone and has long spikes or knobs on the end, at least in male individuals.", 1 / denominator));
        return new EnumeratedDistribution<>(descriptions);
    }
}
