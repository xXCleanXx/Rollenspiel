package com.roleplay.items.armors;

import com.roleplay.items.Item;
import com.roleplay.items.ItemProperties;

public abstract class Armor extends Item {
    private double strength;

    public Armor(ItemProperties itemProperties, double strength) {
        super(itemProperties);

        setStrength(strength);
    }

    public double getStrength() {
        return this.strength;
    }

    protected void setStrength(double strength) {
        if (strength < 0) throw new IllegalArgumentException("Strength cannot be less than 0!");

        this.strength = strength;
    }
}