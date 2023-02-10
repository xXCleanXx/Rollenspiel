package com.roleplay.items.armors;

import com.roleplay.items.Item;

public abstract class Armor extends Item {
    private double strength;

    public Armor(String name, double weight) {
        super(name, weight);
    }

    public double getStrength() {
        return this.strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
}