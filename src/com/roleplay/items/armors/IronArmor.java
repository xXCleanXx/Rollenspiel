package com.roleplay.items.armors;

import com.roleplay.items.Item;

public class IronArmor extends Armor {
    public IronArmor(String name) {
        super(name, 45);
        setStrength(14);
    }

    @Override
    public Item clone() {
        IronArmor armor = new IronArmor(getName());
        armor.setDisplayName(getDisplayName());
        armor.setStrength(getStrength());

        return armor;
    }
}
