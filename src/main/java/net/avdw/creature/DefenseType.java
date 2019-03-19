package net.avdw.creature;

public enum DefenseType {

        Undead_Neutral("ignored by low IQ undead creatures"),
        Invisibility("can disappear at will (fade, vanish with a puff, etc)"),
        Blink("can vanish and reappear elsewhere (nearby, behind foe, etc)"),
        Play_dead("heartbeat/breathing indiscernible, ooze blood, very convincing"),
        Climb("by defying gravity, excellent grip, sticky hands/feet, or other"),
        Levitate("ascend and descend only, can drift with wind currents"),
        Darkness("can reduce light in localized area"),
        Gas_cloud("blinding, obscuring, noxious, or other"),
        Assume_noncorporeal_form("can become gaseous, intangible, etc"),
        Visual_displacement("image appears a short distance from actual location"),
        Quills("projected or used in body contact attacks"),
        Stench("causes opponents to flee or fight at reduced efficiency"),
        Bury_self("only in loose dirt or sand, or can sink into any substance"),
        Lignify_self("can become a tree"),
        Remote_forms("several bodies (extras are dormant until needed?)"),
        Pocket_dimension("can escape into tiny metaspace or personal realm"),
        Translucency("nearly invisible (especially in forest or at night)"),
        Armored("external plating or simply tough skin"),
        Shocking_skin("discharges electricity (only when attacked or harmed)"),
        Menacing_appearance("when threatened, puffs up, hisses, looks mean");

    private String description;

    DefenseType(String description) {

        this.description = description;
    }
}
