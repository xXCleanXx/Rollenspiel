package com.roleplay.items.artefacts;

import com.roleplay.items.artefacts.abstractions.Artefact;
import org.jetbrains.annotations.NotNull;

public class Potion extends Artefact {
    protected Potion(@NotNull String name) {
        super(name);
    }

    @Override
    public void use() {

    }
}