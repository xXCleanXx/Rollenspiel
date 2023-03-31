package com.roleplay.items.armors;

import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class IronArmor extends Armor {
    public IronArmor(ItemProperties itemProperties) {
        super(itemProperties, 6);
        itemProperties.setName("iron");
        itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/iron_32x32.png"));
    }
}