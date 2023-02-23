package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;

public class LeatherArmor extends Armor {
    public LeatherArmor() {
        super("leather_armor", 11, 10);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        LeatherArmor armor = new LeatherArmor();
        armor.setPosition(getPosition());
        armor.setDisplayName(getDisplayName());

        return armor;
    }
}
