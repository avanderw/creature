package net.avdw.creature;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class HeartModule extends AbstractModule {
    private EnumeratedDistribution<String> templates;

    @Override
    protected void configure() {
        templates = createTemplates();
    }

    @Provides
    Heart heart() {
        String template = templates.sample();

        double denominator = 5d;
        List<Pair<Heart, Double>> hearts = new ArrayList<>();
        hearts.add(new Pair<>(new Heart("Bionic", "bionic", template), 1/denominator));
        hearts.add(new Pair<>(new Heart("Metallic", "metallic", template), 1/denominator));
        hearts.add(new Pair<>(new Heart("Cybernetic", "cybernetic", template), 1/denominator));
        hearts.add(new Pair<>(new Heart("Tissue", "fleshy, muscular", template), 1/denominator));
        hearts.add(new Pair<>(new Heart("Mechanical", "mechanical", template), 1/denominator));
        EnumeratedDistribution<Heart> distribution = new EnumeratedDistribution<>(hearts);
        return distribution.sample();
    }

    private EnumeratedDistribution<String> createTemplates() {
        double denominator = 4d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("The rhythmic beat of the #{adjective} heart soothes those alert enough to hear it.", 1/denominator));
        descriptions.add(new Pair<>("The #{adjective} heart pumps continuously.", 1/denominator));
        descriptions.add(new Pair<>("The heart resembles the #{adjective} heart from ancient history.", 1/denominator));
        descriptions.add(new Pair<>("On the inside, the #{adjective} heart is a four-chambered, hollow organ. It is divided into the left and right side by a muscular wall called the septum. The right and left sides of the heart are further divided into two top chambers called the atria, which receive blood from the veins, and two bottom chambers called ventricles, which pump blood into the arteries.", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }

}
