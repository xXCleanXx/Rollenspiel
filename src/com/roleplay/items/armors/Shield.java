package com.roleplay.items.armors;

import com.roleplay.items.Item;
import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Shield extends Item {
    public Shield(ItemProperties itemProperties) {
        super(itemProperties);
        itemProperties.setName("shield");
        itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/shield_32x32.png"));
    }

    public double getStrength() {
        return 2;
    }
}