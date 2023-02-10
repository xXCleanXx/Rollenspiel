package com.roleplay.items.artefacts;

import com.roleplay.items.Item;

public class Potion extends Artefact {
    protected Potion(String name) {
        super(name, 0);
    }

    @Override
    public void use() {

    }

    @Override
    public Item clone() {
        return null;
    }
}