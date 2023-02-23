package com.roleplay.items.weapons;

import com.roleplay.items.Item;

public class Sword extends Weapon {
    protected Sword(double damage) {
        super("sword", 3, damage);
    }

    @Override
    public Item clone() {
        Sword sword = new Sword(getDamage());
        sword.setDisplayName(getDisplayName());

        return sword;
    }
}
