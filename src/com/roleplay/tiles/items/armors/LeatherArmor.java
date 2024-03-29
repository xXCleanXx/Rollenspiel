package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class LeatherArmor extends Armor {
    public LeatherArmor() {
        super("leather_armor", 11, 10);
        loadTexture("src/com/roleplay/resources/images/gras.png");
    }

    @Override
    public Item clone() {
        LeatherArmor armor = new LeatherArmor();
        armor.setPosition(getPosition());
        armor.setDisplayName(getDisplayName());

        return armor;
    }
}
