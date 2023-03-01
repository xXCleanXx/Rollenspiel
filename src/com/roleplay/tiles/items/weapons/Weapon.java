package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;

public abstract class Weapon extends Item {
    private double damage;

    protected Weapon(ItemProperties properties, double damage) {
        super(properties);
        setDamage(damage);
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}