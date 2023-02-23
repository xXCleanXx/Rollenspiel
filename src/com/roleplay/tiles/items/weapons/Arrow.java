package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class Arrow extends Item {
    public Arrow(String name, int id, Point pos) {
        super(name, 0, id, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        return new Arrow(getName(), id, pos);
    }
}