package com.roleplay.items.armors;

import com.roleplay.items.Item;
import com.roleplay.items.ItemProperties;

public class Shield extends Item {
    public Shield(ItemProperties itemProperties) {
        super(itemProperties);
    }

    public double getStrength() {
        return 2;
    }
}