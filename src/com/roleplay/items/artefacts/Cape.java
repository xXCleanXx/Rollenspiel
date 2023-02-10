package com.roleplay.items.artefacts;

import com.roleplay.items.Item;

public class Cape extends Artefact {
    protected Cape(String name) {
        super(name, 0);
    }

    @Override
    public void use() {

    }

    @Override
    public Item clone() {
        return new Cape(getName());
    }
}