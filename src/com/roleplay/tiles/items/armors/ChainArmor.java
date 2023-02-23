package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class ChainArmor extends Armor {
    public ChainArmor(String name, int id, Point pos) {
        super(name, 55, id, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
        setStrength(16);
    }

    @Override
    public Item clone() {
        ChainArmor armor = new ChainArmor(getName(), id, pos);
        armor.setDisplayName(getDisplayName());
        armor.setStrength(getStrength());

        return armor;
    }
}
