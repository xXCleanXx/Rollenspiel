package com.roleplay.items.weapons;

import com.roleplay.items.Item;

public abstract class Weapon extends Item {
    private double damage;

    protected Weapon(String name, double weight, double damage) {
        super(name, weight);
        setDamage(damage);
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}