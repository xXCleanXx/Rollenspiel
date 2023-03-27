package com.roleplay.items.weapons;


import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Sword extends Weapon {
    public Sword(ItemProperties itemProperties) {
        super(itemProperties, 8);
        itemProperties.setName("sword");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/sword_32x32.png"));
    }
}
