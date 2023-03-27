package com.roleplay.items.armors;

import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class ChainArmor extends Armor {
    public ChainArmor(ItemProperties itemProperties) {
        super(itemProperties, 4);
        itemProperties.setName("chain");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/chain_32x32.png"));
    }
}
