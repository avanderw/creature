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

        Body

        01	Man—roughly anthropomorphic
        02	Slug—large, medium or small as desired
        03	Centaur—humanoid from the waist up, animal below
        04	Quadruped, small—an animal like a cat, dog, weasel, wolf or rat
        05	Birdlike—large, medium or small as desired
        06	Serpentine—something like a snake, eel or worm
        07	Ray—flat, like a manta ray; not necessarily aquatic
        08	Fish—not necessarily aquatic
        09	Plant—rooted or ambulatory
        10	Man-animal—roughly anthropomorphic body, but animal-headed
        11	Bug—spider, scorpion, wasp, mantis, moth, tick or crustacean
        12	Blob—an amorphous mass of some organic material
        13	Balloon—a sac, filled with gas or liquid
        14	Squid (or octopus)—not necessarily aquatic
        15	Man-snake—half humanoid, half serpent
        16	Vine—free-roaming or rooted
        17	Quadruped, large—an animal like a bear, horse, deer, goat, puma or bull
        18	Man (Huge)—roughly anthropomorphic, but hulking
        19	Snail—large, medium or small as desired
        20	Starfish—not necessarily aquatic

        Head

        01	Fangs—subtle or pronounced
        02	Slitted eyes—resistance to glare and (perhaps) enhanced vision
        03	Pointed ear—subtle (elfin) or pronounced (wolfish)
        04	Flapped, large—ears covered like a hound dog or elephant
        05	Large—ears are oversized
        06	Single Eye—limited depth perception
        07	Multifaceted—great peripheral vision
        08	Multiple eyes—clustered (great depth perception) or scattered
        09	Snout—enhanced sense of smell
        10	Horns—one or multiple, useful for goring, head butts
        11	Crest—a ridge, tuft, or plume
        12	Eye stalks—can be extended/retracted at will (like a crab or slug)
        13	Forked tongue—enhanced smell
        14	Antlers—useful for goring
        15	Bristles—partial (mane) or full body coverage, stubby or long
        16	Antennae—allow for navigation in total darkness (radar)
        17	Trunk—prehensile, enhanced olfactory capability, good for snorkeling
        18	Headless—head features are absent or elsewhere (like chest or hands)
        19	Tusks—boar-like, for goring
        20	Tentacles—single or multiple, long or short, growing from lips, head, etc

        Locomotion

        01	Glide—can glide when dropping from heights
        02	Marathon—can run for enormous distances without fatigue
        03	Sprint—capable of short bursts of great speed
        04	Jump—hopping (as a mode of travel) or single leap (for attacks)
        05	Burrow—gofer-like means of travel
        06	Teleport—line of sight, to several set locations, or anywhere at will
        07	Swim—might also breathe water, resistant to pressures
        08	Brachiate—must have canopy of tree limbs or overhead handholds
        09	Summon mount—steed, avian or other, comes from distance or appears
        10	Follow river—enter stream at one point, then (instantly?) exit at another
        11	Gate—can teleport from like points (trees, monoliths, pools, coffee shops, etc)
        12	Tumble—can either dry up and drift (tumbleweed), or roll end over end
        13	Step multiply—each step doubles in distance (2′, 4′, 8′, and so on)
        14	Water walk—can walk (or skim) across liquids at will
        15	Land surf—rides a small wave of earth that temporarily liquefies
        16	Fly—full flight capability, with or without wings
        17	Spirit-like—can become ghostly and float along, through solid objects
        18	Electrical—can travel along conducting materials or as a bolt of lightning
        19	Host—enter an object or device, then emerge later at will
        20	Host—enter another creature, emerge later (might not control creature)

        Appendages

        01	Retractable claws—allow for raking attacks and enhanced climbing
        02	Tentacles—in addition to (or instead of) other limbs, many or few
        03	Claws—allow for raking attacks and enhanced climbing
        04	Multiple limbs—copies of limbs, spirit or flesh, perhaps differently sized
        05	Pseudopods–prehensile amoeboid extensions, can be extended/retracted
        06	Odd tongue—prehensile, stinging, forked, extra long, or other
        07	Pistoning limbs—jab forward with great velocity (jaws, arms, tongue, etc)
        08	Tail—prehensile, spiked, stinger-equipped, clubbed, swim-aiding, etc
        09	Fins—enhanced swimming
        10	Wings—bat, bird or insect, for full flight or wing-assisted leaps
        11	Hoofed feet—good for running, strong legs for pulling
        12	Webbed hands or feet—enhanced swimming
        13	Plumes—colorful, perhaps retractable
        14	Snake body—serpentine from the waist down
        15	Exostosis—exposed bony spurs in various places, useful for slicing
        16	Odd aura—faintly radiating nimbus, at will or uncontrollably
        17	Large hands—oversized, strong
        18	Parasites—creature is visibly infested with bug(s) or other thing(s)
        19	Whiskers—long, fine hairs for navigation in darkness
        20	Talons—hands and/or feet are actually falcon-like talons

        Attacks

        01	Mind assault—can cause fear, damage, intense pleasure or apathy
        02	Organic projectile—explosive or ballistic seeds, flesh clumps, teeth
        03	Acid—spat, squirted from orifice, oozed from skin or other
        04	Lignify—can turn opponent into a tree, temporary or permanent
        05	Conjure—can summon creature(s), random or always same type
        06	Pyrotechnic—project, summon or breath flames (streams, shapes or balls)
        07	Electricity—arcs of electrical energy, or summoned lightning from above
        08	Gas—exhaled or sprayed from orifice, blinding, noxious, paralyzing or other
        09	Venomous bite—fangs, external mandibles or tongue , poisons or paralyzes
        10	Venomous claws/spines—poisons or paralyzes
        11	Multiply—can quickly clone self
        12	Thorns—projected or used in bodily contact attacks
        13	Paralytic—by touch, beams or mental attack
        14	Sonic shriek—harmful or stunning noise
        15	Suggestion—spoken or mental projection
        16	Constriction—crushing grip with limbs, tail or other appendage
        17	Sleep—can stun or knock opponent unconscious by some means
        18	Spirit leech—can drain life energy (by touch, gaze, proximity, etc)
        19	Frosty breath—can exhale air at extremely low (damaging) temperatures
        20	Shape shift foe—change enemy into alternate form, random or specific

        Defenses

        01	Undead Neutral—ignored by low IQ undead creatures
        02	Invisibility—can disappear at will (fade, vanish with a puff, etc)
        03	Blink—can vanish and reappear elsewhere (nearby, behind foe, etc)
        04	Play dead—heartbeat/breathing indiscernible, ooze blood, very convincing
        05	Climb—by defying gravity, excellent grip, sticky hands/feet, or other
        06	Levitate—ascend and descend only, can drift with wind currents
        07	Darkness—can reduce light in localized area
        08	Gas cloud—blinding, obscuring, noxious, or other
        09	Assume noncorporeal form—can become gaseous, intangible, etc
        10	Visual displacement—image appears a short distance from actual location
        11	Quills—projected or used in body contact attacks
        12	Stench—causes opponents to flee or fight at reduced efficiency
        13	Bury self—only in loose dirt or sand, or can sink into any substance
        14	Lignify self—can become a tree
        15	Remote/multiple forms—several bodies (extras are dormant until needed?)
        16	Pocket dimension—can escape into tiny metaspace or personal realm
        17	Translucency—nearly invisible (especially in forest or at night)
        18	Armored—external plating or simply tough skin
        19	Shocking skin—discharges electricity (only when attacked or harmed)
        20	Menacing appearance—when threatened, puffs up, hisses, looks mean

        Intelligence and Social Order

        01	Non-intelligent, loner—seeks food, avoids pain, seeks/avoids light
        02	Non-intelligent, group-minded—seeks food, avoids pain, seeks/avoids light
        03	Dumb, loner—incapable of strategy
        04	Dumb, paired—incapable of strategy
        05	Dumb, group—incapable of strategy
        06	Animal, loner—cat level, instinctively tricky
        07	Animal, paired—sheep dog-like tactics
        08	Animal, group—dog-like tactics
        09	Clever, loner—near human level thought, capable of simple planning
        10	Clever, paired—near human level thought, capable of simple planning
        11	Clever, group—near human level thought, capable of simple planning
        12	Human level, loner—can plan and execute complex strategies
        13	Human level, paired—can plan and execute complex strategies
        14	Human level, group—can plan and execute complex strategies
        15	Genius, loner—dazzling feats of logic and intuition
        16	Genius, paired—dazzling feats of logic and intuition
        17	Genius, group—dazzling feats of logic and intuition
        18	Borrowed, loner—psychically utilizes the intellect of foe or nearby sentient
        19	Borrowed, paired—psychically utilizes the intellect of foe or nearby sentient
        20	Borrowed, group—psychically utilizes the intellect of foe or nearby sentient

        Weird Traits

        01	Death change—fades, liquefies, petrifies, reverts or explodes upon death
        02	Animate shadow—creature’s shadow becomes its agent
        03	Commune with dead—can speak with dead, summon ghosts
        04	Gigantically proportioned
        05	Telepathic—one or two way communication
        06	Multi-headed—multiple sentient heads
        07	Secondary form—assume a single alternate body/shape
        08	Shape shift—alter body to any shape desired
        09	Undead—monster is undead (zombie or ghoul-like)
        10	Grow/Shrink—get larger or smaller at will (either or both)
        11	Iron shift, active—skin becomes flexible metal, half mobility
        12	Iron shift, inactive—creates protective metal shell, immobile
        13	Amorphous shift—become a fluid blob at will
        14	Spirit shift—become wraithlike at will, perhaps controls undead
        15	Luminescent eyes—glowing, allows for night vision, easily spotted
        16	Skeletal—flesh/organs nonexistent or hidden within bone frame
        17	Poison flesh—flesh is toxic if consumed
        18	Body switch—can swap bodies with opponent, temporary or permanent
        19	Animated inorganic—active statue, machine or toy
        20	Mental control—can command small creature(s), one type or multiple

        Example Creatures

        Listed below are three examples. In each case, traits were generated with the MG tables, then expanded upon. Each creature was given a name and its characteristics were listed in archived format.


        Example I: Shimmer Cat

        Table Results: (17) quadruped, large; (7) fur; (8) multiple eyes; (2) marathon; (16) odd aura; (1) mind assault; (18) armored; (9) clever, loner; (5) telepathic

        Detailed Explanation: Resembling a mountain lion with dark blue fur and two sets of menacing yellow eyes, the shimmer cat is so named because of the unsettling indigo nimbus which faintly radiates from its body. A creature imported from the Plane of Shadow, it has incredible stamina and is capable of traveling for great distances on foot. Upon nearing an intended victim, the shimmer cat will usually employ stealth, stalking its prey for the thrill of the hunt. The cat will often taunt its victim with demoralizing telepathic images before attacking (with its mental assault ability). Defensively, the shimmer cat relies on its unusually tough skin.

        Shimmer Cat, Archived Format: 17, 7, 8, 2, 16, 1, 18, 9, 5


        Example II: Borzai

        Table Results: (1) man; (18) color shifting; (14) antlers; (15) land surf; (4) multiple limbs; (18) spirit leech; (19) shocking skin; (14) human level, group minded; (1) death change—explodes upon death

        Detailed Explanation: Borzai are malicious, four-armed humanoids with black antlers and skin that constantly shifts in color. Its touch drains the life energy of their opponents, and when struck borzai sometimes unconsciously discharge electricity into the attacker. They are exclusively nocturnal and move about in groups by surfing on a wave of temporarily liquefied earth. Borzai explode upon death.

        Borzai, Archived Format: 1, 18, 14, 15, 4, 18, 19, 14, 1


        Example III: Color Creeper

        Table Results: (14) octopus; (8) bald; (2) slitted eyes; (3) sprint; (3) claws; (8) gas; (1) color change; (8) animal, group minded; (17) poison flesh

        Detailed Explanation: Visually, this monster resembles a land-based octopus with large, slitted eyes. It lives in woodland areas, hunting in packs of up to 30 or so creatures. Using its color changing ability to remain unseen, it slithers into close proximity to its prey. When close, the color creeper sprints forward, hissing, attacking with the claws arranged along its eight tentacles, and releasing clouds of blinding, noxious gas.

        Color Creeper Archived Format: (14, 8, 2, 3, 3, 8, 1, 8, 17)

        Roll each part required by your body plan. If they are in a pack, one of them may be an Elite

        Body Plan – 1d10
        The basic shape of the creature. All body parts of the same type are the same on a creature, unless misshapen which has a different part per roll.
        [1] Humanoid (2 legs, 2 arms, 1 head)
        [2] Quadruped (4 legs, 1 head)
        [3] Tauric (4 legs, 2 arms, 1 head)
        [4] Devi (2 legs, 4 arms, 1 head)
        [5] Bug (6 legs, 1 large head that deals x2 damage)
        [6] Mannequin (4 arms, 1 Surface)
        [7] Wheel (4 legs, 1 Surface)
        [8] Duo-Biped (2 legs, 2 heads)
        [9] Roll again but add a special power.
        [10] Misshapen- Roll on subtable

        Misshapen Table – 1d8
        Roll continuously until you roll an 8.
        [1-2] Roll an Arm
        [3-4] Roll a Leg
        [5-6] Roll a Head
        [7] Elongated Torso. Add +1 HD
        [8] Roll for a Power, then roll one last time on the Misshapen table. That body part controls/emits the random power. Add +1 HD

        Legs Table – 1d12
        [1] Hooves. Fast running, 1d4 kick attack.
        [2] Paws. Nearly silent, +1 initiative
        [3] Insect legs. High jump, +2 more legs.
        [4] Stone wheels. Runs you over, slow turning.
        [5] Tiny black clouds. If blown away; can't move.
        [6] Reptile. +1 AC
        [7] Human, w/ boots. Sounds like marching army.
        [8] Fabric, stuffed with straw. Weak to fire.
        [9] Raptor. Claw deals 1d8 damage.
        [10] Snake tail. No legs. Length is x2 number of monster's legs in feet.
        [11] Jellyfish Tendrils. Floats. Tendrils deal 1d6 poison damage and save or be stunned 1/round.
        [12] Paper. Folded into 'accordion' paper legs. Can extend to make itself taller or shorter. Tall enough to attack flying/floating units. -2 AC

        Arms Table – 1d12
        [1] Tree bark claws. When broken becomes a single entangling tree root/vine.
        [2] Sloth. Huge claws, 1d6 damage and climbing.
        [3] Pulleys w/ rope. Likes to strangle.
        [4] Crab Claws. 1d6 damage, can crack armor.
        [5] Human. Each holds a knife, spear, or shield.
        [6] Ay-ay. Long finger can do 1d4 piercing attack
        [7] Tiger Claws. 1d8 damage.
        [8] Arms end in hammers. 1d6 crushing damage.
        [9] Skeletal. They fall off from Turn Undead
        [10] Transforming. Usually spikes, but can be made into crushing orbs or regular hands.
        [11] Animated Gauntlets. Can do ranged rocket punch moves, but crumble to dust if hit in flight.
        [12] Human, backward joints, unnatural color. Can cast one 1st level spell daily with weird gestures.

        Heads Table – 1d12
        [1] Turtle. Ambushes from water. +1 AC
        [2] Cyclops Goat. Has a special power.
        [3] Jaguar. Deals 1d6 damage, +1 to initiative
        [4] Shark. Deals 1d8 damage.
        [5] Mole. Can detect nearby characters.
        [6] Tusked Humanoid. Retainer morale -1
        [7] Roll an arm. Has an eye in center of palm and shoots 1d6 eye lasers, no save.
        [8] Flaming Pyre. Can breathe fire cone 2d6 damage. Stunned for a round after use.
        [9] King with tin crown. Commands 1d4 faceless, cowardly humanoid creatures w/ spears.
        [10] Tapestry covers face. Takes -1 damage from all spells. Face underneath defies description.
        [11] Big ugly pink pig. Snorts out huge gust of air; blinding dust 1 round and knocks away arrows.
        [12] Vampire Bat. Drain-Bite attack deals 1d6 damage and heals it for same amount.

        Surfaces Table – 1d8
        Flat part of creature w/ magical surface.
        [1] Metal Relief. +1 AC
        [2] Flowers. Animals won't attack it without a morale check, still have -2 to hit.
        [3] Skinless muscles. Deals +2 attack damage.
        [4] Copper Skull. Takes ½ damage from fire.
        [5] Mechanized Mini-Crossbow. Deals 1d4
        [6] Shaggy Hair. Takes ½ damage from cold.
        [7] Twisted Human Face. Striking it forces save or take -1d6 points of Wisdom damage.
        [8] Bright red jewel- creature gets special power. If crystal broken loses that power.

        Random Powers – 1d20
        [1] Glowing eye(s). Extinguishes 1 light source.
        [2] Scorpion Tail. 1d10 poison damage.
        [3] Followed by fog. Gains +2 AC vs ranged.
        [4] Red Orb floats above. +1 HD
        [5] Ethereal. Takes ½ damage from non-magic weapons.
        [6] Spider Thorax. Can shoot Web.
        [7] Covered in thick scales. +2 AC
        [8] Wrapped in magic sheet. +1 AC and Initiative
        [9] Discordant music follows it. -1 to your saves.
        [10] Can squash flat and slip under doors.
        [11] Can cast a random 1st level spell once daily.
        [12] Release octopus ink-cloud when first hit.
        [13] Commands 1d6 featureless wolves.
        [14] Any weapons it possesses are magic +1. Becomes dust upon its death.
        [15] Roll a random damage type. Creature can throw three 1d6 magic bolts of it per day.
        [16] Acid Spit/Piss. Deals 1d4 damage, and can destroys armor on a failed save.
        [17] At half health grows 2 more Arms of a random type. Attacks ferociously with +1 to hit.
        [18] Boiling Blood. Characters take 1 damage on a successful hit with anything shorter then a spear.
        [19] Upon death, splits into 3 identical creatures that deal ½ damage and only have 1 HD
        [20] Roll on surfaces table. Can project this on a nearby wall, heals 1d4 health per round until the surface on the wall is destroyed.