package com.roleplay.items.artefacts;

import com.roleplay.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Potion extends Artefact {
    public Potion(ItemProperties itemProperties, Effect effect) {
        super(itemProperties, effect);
        itemProperties.setName("potion");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/potion_32x32.png"));
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }
}