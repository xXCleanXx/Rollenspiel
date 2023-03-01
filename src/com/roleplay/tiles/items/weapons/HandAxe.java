package com.roleplay.tiles.items.weapons;


import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;

public class HandAxe extends Weapon {
    public HandAxe(ItemProperties itemProperties, double damage) {
        super(itemProperties, damage);
    }

    @Override
    public Item clone() {
        HandAxe handAxe = new HandAxe((ItemProperties) getProperties(), getDamage());

        clone(handAxe, this);

        return handAxe;
    }
}