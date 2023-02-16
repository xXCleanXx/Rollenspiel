package com.roleplay.items.armors;

import com.roleplay.items.Item;

public class LeatherArmor extends Armor {
    public LeatherArmor(String name) {
        super(name, 10);
        setStrength(11);
    }

    @Override
    public Item clone() {
        LeatherArmor armor = new LeatherArmor(getName());
        armor.setDisplayName(getDisplayName());
        armor.setStrength(getStrength());

        return armor;
    }
}
