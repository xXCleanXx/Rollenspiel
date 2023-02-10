package com.roleplay.items.artefacts;

import com.roleplay.items.Item;

public class Ring extends Artefact {
    protected Ring(String name) {
        super(name, 0);
    }

    @Override
    public void use() {

    }

    @Override
    public Item clone() {
        return new Ring(getName());
    }
}
