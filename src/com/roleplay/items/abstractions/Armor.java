package com.roleplay.items.abstractions;

import com.roleplay.items.interfaces.IItem;
import org.jetbrains.annotations.NotNull;

public abstract class Armor implements IItem {
    private String _name;

    public Armor(@NotNull String name) {
        this.setName(name);
    }

    @Override
    public @NotNull String getName() {
        return this._name;
    }

    private void setName(@NotNull String name) {
        this._name = name;
    }
}