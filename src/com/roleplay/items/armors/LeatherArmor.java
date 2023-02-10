package com.roleplay.items.armors;

import com.roleplay.items.Item;

public class LeatherArmor extends Armor {
    public LeatherArmor(String name) {
        super(name, 10);
    }

    @Override
    public Item clone() {
        return null;
    }
}
