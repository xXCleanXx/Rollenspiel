package com.roleplay.items.armors;

import com.roleplay.items.Item;

public class IronArmor extends Armor {

    public IronArmor(String name) {
        super(name, 45);
    }

    @Override
    public Item clone() {
        return null;
    }
}
