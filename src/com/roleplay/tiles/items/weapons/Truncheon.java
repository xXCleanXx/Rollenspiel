package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;

public class Truncheon extends ThrowableWeapon {
    protected Truncheon(ItemProperties itemProperties, double damage, int range) {
        super(itemProperties,damage,range);
    }

    @Override
    public Item clone() {
        Truncheon truncheon = new Truncheon((ItemProperties) getProperties(), getDamage(), getRange());

        clone(truncheon, this);

        return truncheon;
    }
}
