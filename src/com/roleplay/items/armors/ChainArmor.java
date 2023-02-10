package com.roleplay.items.armors;

import com.roleplay.characters.Character;
import com.roleplay.items.Item;

public class ChainArmor extends Armor {
    public ChainArmor(String name) {
        super(name, 55);
        setStrength(16);
    }

    @Override
    public Item clone() {
        ChainArmor armor = new ChainArmor(getName());
        armor.setStrength(getStrength());
        armor.setDisplayName(getDisplayName());

        return null;
    }
}
