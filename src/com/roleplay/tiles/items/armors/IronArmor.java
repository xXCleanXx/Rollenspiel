package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

public class IronArmor extends Armor {
    public IronArmor(ItemProperties itemProperties) {
        super(itemProperties, 14);
    }

    @Override
    public Item clone() {
        IronArmor armor = new IronArmor((ItemProperties) getProperties());
        armor.getProperties().setPosition(getProperties().getPosition());
        ((ItemProperties) armor.getProperties()).setDisplayName(((ItemProperties) getProperties()).getDisplayName());

        return armor;
    }
}