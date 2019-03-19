package net.avdw.creature;

public enum HeadType {

    Fangs("subtle or pronounced"),
    Slitted_eyes("resistance to glare and (perhaps) enhanced vision"),
    Pointed_ear("subtle (elfin) or pronounced (wolfish)"),
    Flapped_large("ears covered like a hound dog or elephant"),
    Large("ears are oversized"),
    Single_Eye("limited depth perception"),
    Multifaceted("great peripheral vision"),
    Multiple_eyes("clustered (great depth perception) or scattered"),
    Snout("enhanced sense of smell"),
    Horns("one or multiple, useful for goring, head butts"),
    Crest("a ridge, tuft, or plume"),
    Eye_stalks("can be extended/retracted at will (like a crab or slug)"),
    Forked_tongue("enhanced smell"),
    Antlers("useful for goring"),
    Bristles("partial (mane) or full body coverage, stubby or long"),
    Antennae("allow for navigation in total darkness (radar)"),
    Trunk("prehensile, enhanced olfactory capability, good for snorkeling"),
    Headless("head features are absent or elsewhere (like chest or hands)"),
    Tusks("boar-like, for goring"),
    Tentacles("single or multiple, long or short, growing from lips, head, etc");

    private String description;

    HeadType(String description) {

        this.description = description;
    }
}
