package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class IronArmor extends Armor {
    public IronArmor(String name, int id, Point pos) {
        super(name, 45,id,pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
        setStrength(14);
    }

    @Override
    public Item clone() {
        IronArmor armor = new IronArmor(getName(), id , pos);
        armor.setDisplayName(getDisplayName());
        armor.setStrength(getStrength());

        return armor;
    }
}
