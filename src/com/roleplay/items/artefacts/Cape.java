package com.roleplay.items.artefacts;

import com.roleplay.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.items.Item;

public class Cape extends Artefact {
    protected Cape(String name, Effect effect) {
        super(name, effect, 0);
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        return new Cape(getName(), getEffect());
    }
}