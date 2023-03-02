package com.roleplay.tiles.items;

public class Key extends Item {

    public Key() {
        super("key", 0);
    }

    @Override
    public Item clone() {
        Key key = new Key();

        clone(key, this);

        return key;
    }
}