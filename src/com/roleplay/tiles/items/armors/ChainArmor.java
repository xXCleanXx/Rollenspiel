package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

public class ChainArmor extends Armor {
    public ChainArmor(ItemProperties itemProperties) {
        super(itemProperties, 16);
    }

    @Override
    public Item clone() {
        ChainArmor armor = new ChainArmor((ItemProperties) getProperties());
        armor.getProperties().setPosition(getProperties().getPosition());
        ((ItemProperties) armor.getProperties()).setDisplayName(((ItemProperties) getProperties()).getDisplayName());

        return armor;
    }
}
