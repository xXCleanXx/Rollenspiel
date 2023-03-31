package com.roleplay.items.weapons;


import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class HandAxe extends Weapon {
    public HandAxe(ItemProperties itemProperties) {
        super(itemProperties, 6);
        itemProperties.setName("handAxe");
        itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/handAxe_32x32.png"));
    }
}