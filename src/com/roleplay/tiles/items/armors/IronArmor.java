package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class IronArmor extends Armor {
    public IronArmor(String name, Point pos) {
        super(name, 45, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
        setStrength(14);
    }

    @Override
    public Item clone() {
        IronArmor armor = new IronArmor(getName(), pos);
        armor.setDisplayName(getDisplayName());
        armor.setStrength(getStrength());

        return armor;
    }
}
