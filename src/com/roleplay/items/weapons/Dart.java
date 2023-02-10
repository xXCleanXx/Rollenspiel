package com.roleplay.items.weapons;

import com.roleplay.items.Item;

public class Dart extends Weapon {

    protected Dart(String name, double damage) {
        super(name, 0.25, damage);
    }

    @Override
    public Item clone() {
        return new Dart(getName(), getDamage());
    }
}
