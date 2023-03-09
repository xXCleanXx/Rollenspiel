package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

public class Shield extends Item {
    public Shield(ItemProperties itemProperties) {
        super(itemProperties);
    }

    public double getStrength() {
        return 2;
    }
}