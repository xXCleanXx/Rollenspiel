package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public abstract class Weapon extends Item {
    private double damage;

    protected Weapon(String name, double weight, double damage, Point pos) {
        super(name, weight, pos);
        setDamage(damage);
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}