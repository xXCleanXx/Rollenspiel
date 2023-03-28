package com.roleplay.items.weapons;


import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class HandAxe extends Weapon {
    public HandAxe(ItemProperties itemProperties) {
        super(itemProperties, 6);
        itemProperties.setName("hand_axe");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/hand_axe_32x32.png"));
    }
}