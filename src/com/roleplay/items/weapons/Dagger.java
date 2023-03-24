package com.roleplay.items.weapons;

import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Dagger extends Weapon {
    public Dagger(ItemProperties itemProperties) {
        super(itemProperties, 4);
        itemProperties.setName("dagger");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/dagger_32x32.png"));
    }
}