package com.roleplay.items.artefacts;

import com.roleplay.items.Item;

public abstract class Artefact extends Item {
    protected Artefact(String name, double weight) {
        super(name, weight);
    }

    public abstract void use();
}
