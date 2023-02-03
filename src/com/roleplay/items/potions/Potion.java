package com.roleplay.items.potions;

import com.roleplay.items.interfaces.IItem;
import org.jetbrains.annotations.NotNull;

public class Potion implements IItem {
    private String _name;

    public Potion(@NotNull String name) {
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