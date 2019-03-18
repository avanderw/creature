package net.avdw.creature;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.ProvidesIntoMap;
import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CreatureModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    List<Arm> arms(Hand hand) {
        int[] legSets = new int[]{0,1,2,3,4};
        double[] probabilities = new double[]{.2,.4,.1,.2,.1};
        EnumeratedIntegerDistribution armSetDistribution = new EnumeratedIntegerDistribution(legSets, probabilities);
        List<Arm> arms = new ArrayList<>();
        IntStream.range(0, armSetDistribution.sample()).forEach(i-> {
            arms.add(new Arm("left", hand));
            arms.add(new Arm("right", hand));
        });
        return arms;
    }

    @Provides
    Hand hand() {
        List<Pair<Hand, Double>> feet = new ArrayList<>();
        feet.add(new Pair<>(new Hand("bionic"), .2));
        feet.add(new Pair<>(new Hand("scissor"), .2));
        feet.add(new Pair<>(new Hand("claw"), .2));
        feet.add(new Pair<>(new Hand("talon"), .2));
        feet.add(new Pair<>(new Hand("hand"), .2));
        EnumeratedDistribution<Hand> distro = new EnumeratedDistribution<>(feet);
        return distro.sample();
    }

    @Provides
    List<Head> heads() {
        List<Head> heads = new ArrayList<>();
        IntStream.range(0, new Random().nextInt(6) + 1).forEach(i-> heads.add(new Head()));
        return heads;
    }

    @Provides
    List<Leg> legs(Foot foot) {
        int[] legSets = new int[]{0,1,2,3,4};
        double[] probabilities = new double[]{.2,.4,.1,.2,.1};
        EnumeratedIntegerDistribution legSetDistribution = new EnumeratedIntegerDistribution(legSets, probabilities);
        List<Leg> legs = new ArrayList<>();
        IntStream.range(0, legSetDistribution.sample()).forEach(i-> {
            legs.add(new Leg("left", foot));
            legs.add(new Leg("right", foot));
        });
        return legs;
    }

    @Provides
    Foot foot() {
        List<Pair<Foot, Double>> feet = new ArrayList<>();
        feet.add(new Pair<>(new Foot("bionic"), .2));
        feet.add(new Pair<>(new Foot("scissor"), .2));
        feet.add(new Pair<>(new Foot("claw"), .2));
        feet.add(new Pair<>(new Foot("talon"), .2));
        feet.add(new Pair<>(new Foot("hand"), .2));
        EnumeratedDistribution<Foot> distro = new EnumeratedDistribution<>(feet);
        return distro.sample();
    }

    @Provides
    Tail tail() {
        List<Pair<Tail, Double>> tail = new ArrayList<>();
        tail.add(new Pair<>(new Tail("bionic"), .2));
        tail.add(new Pair<>(new Tail("spiked"), .2));
        tail.add(new Pair<>(new Tail("stub"), .2));
        tail.add(new Pair<>(new Tail("short"), .2));
        tail.add(new Pair<>(new Tail("long"), .2));
        EnumeratedDistribution<Tail> distro = new EnumeratedDistribution<>(tail);
        return distro.sample();
    }

    @Provides
    List<Tail> tails(Tail tail) {
        int[] counts = new int[]{0,1,2,3};
        double[] probabilities = new double[]{.1,.5,.1,.3};
        EnumeratedIntegerDistribution distro = new EnumeratedIntegerDistribution(counts, probabilities);
        List<Tail> tails = new ArrayList<>();
        IntStream.range(0, new Random().nextInt(distro.sample()+1)).forEach(i-> tails.add(tail));
        return tails;
    }

    @Provides
    List<Wing> wings() {
        List<Wing> wings =new ArrayList<>();
        IntStream.range(0, new Random().nextInt(2)).forEach(i-> {
            wings.add(new Wing());
            wings.add(new Wing());
        });
        return wings;
    }

    @Provides
    Heart heart() {
        List<Pair<Heart, Double>> hearts = new ArrayList<>();
        hearts.add(new Pair<>(new Heart("bionic"), 0.4));
        hearts.add(new Pair<>(new Heart("diamond"), 0.1));
        hearts.add(new Pair<>(new Heart("cybernetic"), 0.3));
        hearts.add(new Pair<>(new Heart("tissue"), 0.2));
        EnumeratedDistribution<Heart> distribution = new EnumeratedDistribution<>(hearts);
        return distribution.sample();
    }

    @Provides
    Skin skin() {
        List<Pair<Skin, Double>> skins = new ArrayList<>();
        skins.add(new Pair<>(new Skin("Feathers", "resistant to water"), 1./21));
        skins.add(new Pair<>(new Skin("Tough", "normal appearance, but resistant to minor heat or damage"), 1./21));
        skins.add(new Pair<>(new Skin("Smokey", "constantly emits wispy vapors"), 1./21));
        skins.add(new Pair<>(new Skin("Shadowy", "skin absorbs light, wraith-like"), 1./21));
        skins.add(new Pair<>(new Skin("Flesh", "mostly flesh, patches of fur or hair"), 1./21));
        skins.add(new Pair<>(new Skin("Scales", "partially or fully scaled, resistant to attacks"), 1./21));
        skins.add(new Pair<>(new Skin("Spots", "partially or fully spotted, various color schemes"), 1./21));
        skins.add(new Pair<>(new Skin("Fur", "protection from cold"), 1./21));
        skins.add(new Pair<>(new Skin("Bald", "creature is hairless, fleshy"), 1./21));
        skins.add(new Pair<>(new Skin("Sores", "scabbed or oozing pus"), 1./21));
        skins.add(new Pair<>(new Skin("Ridges", "corrugated flesh or ridges of exposed bone"), 1./21));
        skins.add(new Pair<>(new Skin("Spines", "creature has partial or full coverage"), 1./21));
        skins.add(new Pair<>(new Skin("Moldy", "host to a thick, colorful skin fungus, or actually is a fungus"), 1./21));
        skins.add(new Pair<>(new Skin("Carapace", "shell—bone or chitin armor, highly resistant to damage"), 1./21));
        skins.add(new Pair<>(new Skin("Loose", "able to glide down from heights and/or enwrap victim"), 1./21));
        skins.add(new Pair<>(new Skin("Ciliated", "covered in wiggling cilia, long or short, thick or skinny"), 1./21));
        skins.add(new Pair<>(new Skin("Bioluminescent", "glows faintly or brightly, constantly or at will"), 1./21));
        skins.add(new Pair<>(new Skin("Transparent", "internal organs and half-digested foods are visible"), 1./21));
        skins.add(new Pair<>(new Skin("Chameleon", "chameleonic, colour shifting"), 1./21));
        skins.add(new Pair<>(new Skin("Slimy", "covered with a gel or mucus-like substance"), 1./21));
        skins.add(new Pair<>(new Skin("Stripes", "partially or fully, various color schemes"), 1./21));

        EnumeratedDistribution<Skin> distribution = new EnumeratedDistribution<>(skins);
        return distribution.sample();
    }
}
