package com.roleplay.items.weapons;

import com.roleplay.items.ItemProperties;

public abstract class ThrowableWeapon extends Weapon {
    private int range = 0;

    protected ThrowableWeapon(ItemProperties itemProperties, double damage, int range) {
        super(itemProperties, damage);

        setRange(range);
    }

    public int getRange() {
        return range;
    }

    protected void setRange(int range) {
        if (range < 0) throw new IllegalArgumentException("Range cannot be less than 0!");

        this.range = range;
    }
}
