package com.roleplay.items.artefacts;

import com.roleplay.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.items.ItemProperties;

public class Ring extends Artefact {
    public Ring(ItemProperties itemProperties, Effect effect) {
        super(itemProperties, effect);
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }
}
