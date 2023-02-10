package com.roleplay.spells;

public class Spell {
    private final String name;
    private final SpellEffect effect;

    public Spell(String name, SpellEffect effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void use() {

    }
}