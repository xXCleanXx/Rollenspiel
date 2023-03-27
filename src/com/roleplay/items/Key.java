package com.roleplay.items;

import com.roleplay.tools.ImageUtils;

import java.awt.*;

public class Key extends Item {
    public Key(ItemProperties itemProperties) {
        super(itemProperties);
        itemProperties.setName("key");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/key_32x32.png"));

    }
}