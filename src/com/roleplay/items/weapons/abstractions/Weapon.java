package com.roleplay.items.weapons.abstractions;

import com.roleplay.items.interfaces.IItem;
import org.jetbrains.annotations.NotNull;

public abstract class Weapon implements IItem {
    private final double _damage;
    private String _name;

    public Weapon(@NotNull String name, double damage) {
        this.setName(name);
        this._damage = damage;
    }

    public double getDamage() {
        return this._damage;
    }

    @Override
    public @NotNull String getName() {
        return this._name;
    }

    private void setName(@NotNull String name) {
        this._name = name;
    }
}