package com.roleplay.items.weapons;

import com.roleplay.items.Item;

public class Spear extends Weapon {
    public Spear(double damage) {
        super("spear", 3, damage);
    }

    @Override
    public Item clone() {
        Spear spear = new Spear(getDamage());
        spear.setDisplayName(getDisplayName());

        return spear;
    }
}