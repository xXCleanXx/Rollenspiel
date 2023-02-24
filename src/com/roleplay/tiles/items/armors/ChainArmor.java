package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class ChainArmor extends Armor {
    public ChainArmor() {
        super("chain_armor", 16, 55);
        loadTexture("src/com/roleplay/resources/images/gras.png");
    }

    @Override
    public Item clone() {
        ChainArmor armor = new ChainArmor();
        armor.setPosition(getPosition());
        armor.setDisplayName(getDisplayName());

        return armor;
    }
}
