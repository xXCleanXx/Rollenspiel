package com.roleplay.items.weapons;

import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Bow extends ThrowableWeapon {
    public Bow(ItemProperties itemProperties) {
        super(itemProperties, 8, 6);
        itemProperties.setName("bow");
        itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/bow_32x32.png"));
    }
}