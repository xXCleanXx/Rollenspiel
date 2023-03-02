package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

public class Bow extends Weapon {
    protected Bow(ItemProperties itemProperties, double damage) {
        super(itemProperties, damage);
    }

    @Override
    public Item clone() {
        Bow bow = new Bow((ItemProperties) getProperties(), getDamage());

        clone(bow, this);

        return bow;
    }
}