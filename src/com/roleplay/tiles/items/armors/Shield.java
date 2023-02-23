package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class Shield extends Armor {
    public Shield(String name, Point pos) {
        super(name, 6, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        return new Shield(getName(), getPos());
    }
}