package net.avdw.creature;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
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
        install(new BodyModule());

        bind(Describer.class).to(CreatureDescriber.class);
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



    @Provides @Named("creature-description-template")
    String template(@Named("creature-description-templates") EnumeratedDistribution<String> templates) {
        return templates.sample();
    }

    @Provides @Singleton @Named("creature-description-templates")
    EnumeratedDistribution<String> templates() {
        double denominator = 1d;
        List<Pair<String, Double>> descriptions = new ArrayList<>();
        descriptions.add(new Pair<>("The todo:name has a #{body}", 1/denominator));
        return new EnumeratedDistribution<>(descriptions);
    }

}


//        Example Creatures
//
//        Listed below are three examples. In each case, traits were generated with the MG tables, then expanded upon. Each creature was given a name and its characteristics were listed in archived format.
//
//
//        Example I: Shimmer Cat
//
//        Table Results: (17) quadruped, large; (7) fur; (8) multiple eyes; (2) marathon; (16) odd aura; (1) mind assault; (18) armored; (9) clever, loner; (5) telepathic
//
//        Detailed Explanation: Resembling a mountain lion with dark blue fur and two sets of menacing yellow eyes, the shimmer cat is so named because of the unsettling indigo nimbus which faintly radiates from its body. A creature imported from the Plane of Shadow, it has incredible stamina and is capable of traveling for great distances on foot. Upon nearing an intended victim, the shimmer cat will usually employ stealth, stalking its prey for the thrill of the hunt. The cat will often taunt its victim with demoralizing telepathic images before attacking (with its mental assault ability). Defensively, the shimmer cat relies on its unusually tough skin.
//
//        Shimmer Cat, Archived Format: 17, 7, 8, 2, 16, 1, 18, 9, 5
//
//
//        Example II: Borzai
//
//        Table Results: (1) man; (18) color shifting; (14) antlers; (15) land surf; (4) multiple limbs; (18) spirit leech; (19) shocking skin; (14) human level, group minded; (1) death change—explodes upon death
//
//        Detailed Explanation: Borzai are malicious, four-armed humanoids with black antlers and skin that constantly shifts in color. Its touch drains the life energy of their opponents, and when struck borzai sometimes unconsciously discharge electricity into the attacker. They are exclusively nocturnal and move about in groups by surfing on a wave of temporarily liquefied earth. Borzai explode upon death.
//
//        Borzai, Archived Format: 1, 18, 14, 15, 4, 18, 19, 14, 1
//
//
//        Example III: Color Creeper
//
//        Table Results: (14) octopus; (8) bald; (2) slitted eyes; (3) sprint; (3) claws; (8) gas; (1) color change; (8) animal, group minded; (17) poison flesh
//
//        Detailed Explanation: Visually, this monster resembles a land-based octopus with large, slitted eyes. It lives in woodland areas, hunting in packs of up to 30 or so creatures. Using its color changing ability to remain unseen, it slithers into close proximity to its prey. When close, the color creeper sprints forward, hissing, attacking with the claws arranged along its eight tentacles, and releasing clouds of blinding, noxious gas.
//
//        Color Creeper Archived Format: (14, 8, 2, 3, 3, 8, 1, 8, 17)
//
//        Roll each part required by your body plan. If they are in a pack, one of them may be an Elite
//
//        Body Plan – 1d10
//        The basic shape of the creature. All body parts of the same type are the same on a creature, unless misshapen which has a different part per roll.
//        [1] Humanoid (2 legs, 2 arms, 1 head)
//        [2] Quadruped (4 legs, 1 head)
//        [3] Tauric (4 legs, 2 arms, 1 head)
//        [4] Devi (2 legs, 4 arms, 1 head)
//        [5] Bug (6 legs, 1 large head that deals x2 damage)
//        [6] Mannequin (4 arms, 1 Surface)
//        [7] Wheel (4 legs, 1 Surface)
//        [8] Duo-Biped (2 legs, 2 heads)
//        [9] Roll again but add a special power.
//        [10] Misshapen- Roll on subtable
//
//        Misshapen Table – 1d8
//        Roll continuously until you roll an 8.
//        [1-2] Roll an Arm
//        [3-4] Roll a Leg
//        [5-6] Roll a Head
//        [7] Elongated Torso. Add +1 HD
//        [8] Roll for a Power, then roll one last time on the Misshapen table. That body part controls/emits the random power. Add +1 HD
//
//        Legs Table – 1d12
//        [1] Hooves. Fast running, 1d4 kick attack.
//        [2] Paws. Nearly silent, +1 initiative
//        [3] Insect legs. High jump, +2 more legs.
//        [4] Stone wheels. Runs you over, slow turning.
//        [5] Tiny black clouds. If blown away; can't move.
//        [6] Reptile. +1 AC
//        [7] Human, w/ boots. Sounds like marching army.
//        [8] Fabric, stuffed with straw. Weak to fire.
//        [9] Raptor. Claw deals 1d8 damage.
//        [10] Snake tail. No legs. Length is x2 number of monster's legs in feet.
//        [11] Jellyfish Tendrils. Floats. Tendrils deal 1d6 poison damage and save or be stunned 1/round.
//        [12] Paper. Folded into 'accordion' paper legs. Can extend to make itself taller or shorter. Tall enough to attack flying/floating units. -2 AC
//
//        Arms Table – 1d12
//        [1] Tree bark claws. When broken becomes a single entangling tree root/vine.
//        [2] Sloth. Huge claws, 1d6 damage and climbing.
//        [3] Pulleys w/ rope. Likes to strangle.
//        [4] Crab Claws. 1d6 damage, can crack armor.
//        [5] Human. Each holds a knife, spear, or shield.
//        [6] Ay-ay. Long finger can do 1d4 piercing attack
//        [7] Tiger Claws. 1d8 damage.
//        [8] Arms end in hammers. 1d6 crushing damage.
//        [9] Skeletal. They fall off from Turn Undead
//        [10] Transforming. Usually spikes, but can be made into crushing orbs or regular hands.
//        [11] Animated Gauntlets. Can do ranged rocket punch moves, but crumble to dust if hit in flight.
//        [12] Human, backward joints, unnatural color. Can cast one 1st level spell daily with weird gestures.
//
//        Heads Table – 1d12
//        [1] Turtle. Ambushes from water. +1 AC
//        [2] Cyclops Goat. Has a special power.
//        [3] Jaguar. Deals 1d6 damage, +1 to initiative
//        [4] Shark. Deals 1d8 damage.
//        [5] Mole. Can detect nearby characters.
//        [6] Tusked Humanoid. Retainer morale -1
//        [7] Roll an arm. Has an eye in center of palm and shoots 1d6 eye lasers, no save.
//        [8] Flaming Pyre. Can breathe fire cone 2d6 damage. Stunned for a round after use.
//        [9] King with tin crown. Commands 1d4 faceless, cowardly humanoid creatures w/ spears.
//        [10] Tapestry covers face. Takes -1 damage from all spells. Face underneath defies description.
//        [11] Big ugly pink pig. Snorts out huge gust of air; blinding dust 1 round and knocks away arrows.
//        [12] Vampire Bat. Drain-Bite attack deals 1d6 damage and heals it for same amount.
//
//        Surfaces Table – 1d8
//        Flat part of creature w/ magical surface.
//        [1] Metal Relief. +1 AC
//        [2] Flowers. Animals won't attack it without a morale check, still have -2 to hit.
//        [3] Skinless muscles. Deals +2 attack damage.
//        [4] Copper Skull. Takes ½ damage from fire.
//        [5] Mechanized Mini-Crossbow. Deals 1d4
//        [6] Shaggy Hair. Takes ½ damage from cold.
//        [7] Twisted Human Face. Striking it forces save or take -1d6 points of Wisdom damage.
//        [8] Bright red jewel- creature gets special power. If crystal broken loses that power.
//
//        Random Powers – 1d20
//        [1] Glowing eye(s). Extinguishes 1 light source.
//        [2] Scorpion Tail. 1d10 poison damage.
//        [3] Followed by fog. Gains +2 AC vs ranged.
//        [4] Red Orb floats above. +1 HD
//        [5] Ethereal. Takes ½ damage from non-magic weapons.
//        [6] Spider Thorax. Can shoot Web.
//        [7] Covered in thick scales. +2 AC
//        [8] Wrapped in magic sheet. +1 AC and Initiative
//        [9] Discordant music follows it. -1 to your saves.
//        [10] Can squash flat and slip under doors.
//        [11] Can cast a random 1st level spell once daily.
//        [12] Release octopus ink-cloud when first hit.
//        [13] Commands 1d6 featureless wolves.
//        [14] Any weapons it possesses are magic +1. Becomes dust upon its death.
//        [15] Roll a random damage type. Creature can throw three 1d6 magic bolts of it per day.
//        [16] Acid Spit/Piss. Deals 1d4 damage, and can destroys armor on a failed save.
//        [17] At half health grows 2 more Arms of a random type. Attacks ferociously with +1 to hit.
//        [18] Boiling Blood. Characters take 1 damage on a successful hit with anything shorter then a spear.
//        [19] Upon death, splits into 3 identical creatures that deal ½ damage and only have 1 HD
//        [20] Roll on surfaces table. Can project this on a nearby wall, heals 1d4 health per round until the surface on the wall is destroyed.