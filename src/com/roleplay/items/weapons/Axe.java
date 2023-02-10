package com.roleplay.items.weapons;

import com.roleplay.items.Item;

public class Axe extends Weapon {
    public Axe(String name, double damage) {
        super(name, 2, damage);
    }

    @Override
    public Item clone() {
        return new Axe(getName(), getDamage());
    }
}
