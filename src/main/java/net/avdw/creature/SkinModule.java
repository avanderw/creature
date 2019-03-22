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

public class SkinModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Describer.class).annotatedWith(Names.named("skin")).to(SkinDescriber.class);
    }

    @Provides
    Skin skin(EnumeratedDistribution<Skin> distribution) {
        return distribution.sample();
    }

    @Provides
    @Named("skin-description-template")
    String template(EnumeratedDistribution<Skin> templates) {
        return String.format("skin{%s}",templates.sample().description);
    }

    @Provides
    @Singleton
    EnumeratedDistribution<Skin> templates() {
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

        return new EnumeratedDistribution<>(skins);
    }

}
