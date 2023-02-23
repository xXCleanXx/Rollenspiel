package com.roleplay.tiles;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class Key extends Item {

    public Key(String name, double weight, Point pos) {
        super(name, weight, pos);
    }

    @Override
    public Item clone() {
        return new Key(getName(), getWeight(), getPos());
    }
}