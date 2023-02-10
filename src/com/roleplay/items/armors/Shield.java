package com.roleplay.items.armors;

import com.roleplay.items.Item;

public class Shield extends Armor {
    public Shield(String name) {
        super(name, 6);
    }

    @Override
    public Item clone() {
        return new Shield(getName());
    }
}