package com.roleplay.items.weapons;


import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Spear extends ThrowableWeapon {
    public Spear(ItemProperties itemProperties) {
        super(itemProperties, 6, 2);
        itemProperties.setName("spear");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/spear_32x32.png"));
    }
}