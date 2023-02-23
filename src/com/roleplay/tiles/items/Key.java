package com.roleplay.tiles.items;

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