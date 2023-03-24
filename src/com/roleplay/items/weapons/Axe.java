package com.roleplay.items.weapons;

import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Axe extends Weapon {
    public Axe(ItemProperties itemProperties) {
        super(itemProperties, 6);
        itemProperties.setName("axe");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/axe_32x32.png"));
    }
}