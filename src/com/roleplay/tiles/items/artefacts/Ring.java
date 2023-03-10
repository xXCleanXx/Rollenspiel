package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.properties.ItemProperties;


public class Ring extends Artefact {
    public Ring(ItemProperties itemProperties, Effect effect) {
        super(itemProperties, effect);
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }
}
