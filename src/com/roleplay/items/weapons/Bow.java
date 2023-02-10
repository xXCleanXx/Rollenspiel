package com.roleplay.items.weapons;

import com.roleplay.items.Item;

public class Bow extends Weapon {
    protected Bow(String name, double damage) {
        super(name, 2, damage);
    }

    @Override
    public Item clone() {
        return new Bow(getName(), getDamage());
    }
}