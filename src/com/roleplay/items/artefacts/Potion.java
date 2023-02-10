package com.roleplay.items.artefacts;

import com.roleplay.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.items.Item;

public class Potion extends Artefact {
    protected Potion(String name, Effect effect) {
        super(name, effect, 0);
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        return new Potion(getName(), getEffect());
    }
}