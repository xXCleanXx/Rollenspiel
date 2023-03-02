package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;

public abstract class ThrowableWeapon extends Weapon {
    private int range = 0;

    protected ThrowableWeapon(String name, double weight, double damage, int range) {
        super(name, weight, damage);

        setRange(range);
    }

    public int getRange() {
        return range;
    }

    protected void setRange(int range) {
        if (range < 0) throw new IllegalArgumentException("Range cannot be less than 0!");

        this.range = range;
    }

    public abstract Item clone();
}
