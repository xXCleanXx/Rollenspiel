package com.roleplay.items.weapons;

import com.roleplay.items.interfaces.IItem;
import org.jetbrains.annotations.NotNull;

public class Arrow implements IItem {
    private String _name;

    public Arrow(@NotNull String name) {
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
