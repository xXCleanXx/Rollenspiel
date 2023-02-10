package com.roleplay.items.weapons;

import com.roleplay.items.Item;

public class Dagger extends Weapon {
    public Dagger(String name, double damage) {
        super(name, 2, damage);
    }

    @Override
    public Item clone() {
        return new Dagger(getName(), getDamage());
    }
}