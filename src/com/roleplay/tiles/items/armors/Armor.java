package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public abstract class Armor extends Item {
    private double strength;

    public Armor(String name, double weight, Point pos) {
        super(name, weight,  pos);
    }

    public double getStrength() {
        return this.strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
}