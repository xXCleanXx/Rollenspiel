package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

public class LeatherArmor extends Armor {
    public LeatherArmor(ItemProperties itemProperties) {
        super(itemProperties, 11);
    }

    @Override
    public Item clone() {
        LeatherArmor armor = new LeatherArmor((ItemProperties) getProperties());
        armor.getProperties().setPosition(getProperties().getPosition());
        ((ItemProperties) armor.getProperties()).setDisplayName(((ItemProperties) getProperties()).getDisplayName());

        return armor;
    }
}
