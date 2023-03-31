package com.roleplay.items.artefacts;

import com.roleplay.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Amulet extends Artefact {
    public Amulet(ItemProperties itemProperties, Effect effect) {
        super(itemProperties, effect);
        itemProperties.setName("amulet");
        itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/amulet_32x32.png"));
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }
}
