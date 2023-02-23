package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class LeatherArmor extends Armor {
    public LeatherArmor(String name, int id, Point pos) {
        super(name, 10, id, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
        setStrength(11);
    }

    @Override
    public Item clone() {
        LeatherArmor armor = new LeatherArmor(getName(), id, pos);
        armor.setDisplayName(getDisplayName());
        armor.setStrength(getStrength());

        return armor;
    }
}