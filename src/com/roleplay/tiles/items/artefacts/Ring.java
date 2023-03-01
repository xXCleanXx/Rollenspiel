package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;


public class Ring extends Artefact {
    public Ring(ItemProperties itemProperties, Effect effect) {
        super(itemProperties, effect);
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        Ring ring = new Ring((ItemProperties) getProperties(),getEffect());
        ring.getProperties().setPosition(getProperties().getPosition());
        ((ItemProperties) ring.getProperties()).setDisplayName(((ItemProperties) getProperties()).getDisplayName());

        return ring;
    }
}
