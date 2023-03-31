package com.roleplay.items.artefacts;

import com.roleplay.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Ring extends Artefact {
    public Ring(ItemProperties itemProperties, Effect effect) {
        super(itemProperties, effect);
        itemProperties.setName("ring");
        itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/ring_32x32.png"));
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }
}
