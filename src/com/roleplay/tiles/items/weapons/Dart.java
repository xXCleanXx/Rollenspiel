package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

public class Dart extends Weapon {

    protected Dart(ItemProperties itemProperties, double damage) {
        super(itemProperties, damage);
    }

    @Override
    public Item clone() {
        Dart dart = new Dart((ItemProperties) getProperties(), getDamage());

        clone(dart, this);

        return dart;
    }
}
