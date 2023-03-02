package com.roleplay.tiles.items.weapons;


import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;

public class Spear extends ThrowableWeapon {
    public Spear(ItemProperties itemProperties, double damage, int range) {
        super(itemProperties, damage, range);
    }

    @Override
    public Item clone() {
        Spear spear = new Spear((ItemProperties) getProperties(), getDamage(), getRange());
        clone(spear, this);

        return spear;
    }
}