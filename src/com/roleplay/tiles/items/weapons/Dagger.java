package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

public class Dagger extends Weapon {
    public Dagger(ItemProperties itemProperties, double damage) {
        super(itemProperties, damage);
    }

    @Override
    public Item clone() {
        Dagger dagger = new Dagger((ItemProperties) getProperties(), getDamage());

        clone(dagger, this);

        return dagger;
    }
}