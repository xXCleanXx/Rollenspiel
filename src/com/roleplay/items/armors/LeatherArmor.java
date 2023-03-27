package com.roleplay.items.armors;

import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class LeatherArmor extends Armor {
    public LeatherArmor(ItemProperties itemProperties) {
        super(itemProperties, 1);
        itemProperties.setName("leather");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/leather_32x32.png"));
    }
}
