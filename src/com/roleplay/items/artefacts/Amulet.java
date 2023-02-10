package com.roleplay.items.artefacts;

import com.roleplay.items.Item;

public class Amulet extends Artefact {
    protected Amulet(String name) {
        super(name, 0);
    }

    @Override
    public void use() {

    }

    @Override
    public Item clone() {
        return new Amulet(getName());
    }
}
