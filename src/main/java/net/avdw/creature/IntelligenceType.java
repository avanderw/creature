package net.avdw.creature;

public enum IntelligenceType {

    Non_intelligent_loner("seeks food, avoids pain, seeks/avoids light"),
    Non_intelligent_group_minded("seeks food, avoids pain, seeks/avoids light"),
    Dumb_loner("incapable of strategy"),
    Dumb_paired("incapable of strategy"),
    Dumb_group("incapable of strategy"),
    Animal_loner("cat level, instinctively tricky"),
    Animal_paired("sheep dog-like tactics"),
    Animal_group("dog-like tactics"),
    Clever_loner("near human level thought, capable of simple planning"),
    Clever_paired("near human level thought, capable of simple planning"),
    Clever_group("near human level thought, capable of simple planning"),
    Human_level_loner("can plan and execute complex strategies"),
    Human_level_paired("can plan and execute complex strategies"),
    Human_level_group("can plan and execute complex strategies"),
    Genius_loner("dazzling feats of logic and intuition"),
    Genius_paired("dazzling feats of logic and intuition"),
    Genius_group("dazzling feats of logic and intuition"),
    Borrowed_loner("psychically utilizes the intellect of foe or nearby sentient"),
    Borrowed_paired("psychically utilizes the intellect of foe or nearby sentient"),
    Borrowed_group("psychically utilizes the intellect of foe or nearby sentient");
    private String description;

    IntelligenceType(String description) {

        this.description = description;
    }
}
