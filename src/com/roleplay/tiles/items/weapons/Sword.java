package com.roleplay.tiles.items.weapons;


import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;

public class Sword extends Weapon {
    protected Sword(ItemProperties properties, double damage) {
        super(properties, damage);
    }

    @Override
    public Item clone() {
        Sword sword = new Sword((ItemProperties) getProperties(), getDamage());

        clone(sword, this);

        return sword;
    }
}
