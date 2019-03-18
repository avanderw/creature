package net.avdw.creature;

public class Foot {
    private String name;

    public Foot(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
