package com.roleplay.items.artefacts.abstractions;

import com.roleplay.items.interfaces.IItem;
import org.jetbrains.annotations.NotNull;

public abstract class Artefact implements IItem {
    private String _name;

    protected Artefact(@NotNull String name) {
        this.setName(name);
    }

    @Override
    public @NotNull String getName() {
        return this._name;
    }

    private void setName(@NotNull String name) {
        this._name = name;
    }

    public abstract void use();
}
