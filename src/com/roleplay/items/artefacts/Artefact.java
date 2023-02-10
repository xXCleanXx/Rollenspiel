package com.roleplay.items.artefacts;

import com.roleplay.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.items.Item;

public abstract class Artefact extends Item {
    private final Effect effect;

    protected Artefact(String name, Effect effect, double weight) {
        super(name, weight);
        this.effect = effect;
    }

    public Effect getEffect() {
        return effect;
    }

    public abstract void use(Character character);
}
