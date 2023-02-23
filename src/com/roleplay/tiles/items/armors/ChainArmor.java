package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class ChainArmor extends Armor {
    public ChainArmor(String name, Point pos) {
        super(name, 55, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
        setStrength(16);
    }

    @Override
    public Item clone() {
        ChainArmor armor = new ChainArmor(getName(), pos);
        armor.setDisplayName(getDisplayName());
        armor.setStrength(getStrength());

        return armor;
    }
}
