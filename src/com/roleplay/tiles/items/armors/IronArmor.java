package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class IronArmor extends Armor {
    public IronArmor() {
        super("iron_armor", 14, 45);
        loadTexture("src/com/roleplay/resources/images/gras.png");
    }

    @Override
    public Item clone() {
        IronArmor armor = new IronArmor();
        armor.setPosition(getPosition());
        armor.setDisplayName(getDisplayName());

        return armor;
    }
}