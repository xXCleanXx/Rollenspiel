package com.roleplay.spells;

import com.roleplay.effects.Effect;
import com.roleplay.tiles.characters.Character;

public abstract class Spell {
    private final String name;
    private final Effect effect;

    public Spell(String name, Effect effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void use(Character character) {
        effect.apply(character);
    }
}