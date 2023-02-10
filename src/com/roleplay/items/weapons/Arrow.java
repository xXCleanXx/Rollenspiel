package com.roleplay.items.weapons;

import com.roleplay.items.Item;

public class Arrow extends Item {
    public Arrow(String name) {
        super(name, 0);
    }

    @Override
    public Item clone() {
        return new Arrow(getName());
    }
}