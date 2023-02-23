package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;

public abstract class Armor extends Item {
    private double strength;

    public Armor(String name, double strength, double weight) {
        super(name, weight);
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