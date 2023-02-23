package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class LeatherArmor extends Armor {
    public LeatherArmor(String name, Point pos) {
        super(name, 10, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
        setStrength(11);
    }

    @Override
    public Item clone() {
        LeatherArmor armor = new LeatherArmor(getName(),getPos());
        armor.setDisplayName(getDisplayName());
        armor.setStrength(getStrength());

        return armor;
    }
}
