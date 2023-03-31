package com.roleplay.items.weapons;

import com.roleplay.items.Item;
import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Arrow extends Item {
    public Arrow(ItemProperties itemProperties) {
        super(itemProperties);
        itemProperties.setName("arrow");
        itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/arrow_32x32.png"));
    }

}