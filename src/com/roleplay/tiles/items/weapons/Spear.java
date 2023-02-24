package com.roleplay.tiles.items.weapons;


import com.roleplay.tiles.items.Item;

public class Spear extends ThrowableWeapon {
    public Spear(double damage) {
        super("spear", 3, damage, 2);
    }

    @Override
    public Item clone() {
        Spear spear = new Spear(getDamage());
        clone(spear, this);

        return spear;
    }
}