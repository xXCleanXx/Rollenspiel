package com.roleplay.tiles.items;

public class Key extends Item {

    public Key() {
        super("key", 0);
    }

    @Override
    public Item clone() {
        Key key = new Key();
        key.setPosition(getPosition());
        key.setDisplayName(getDisplayName());

        return key;
    }
}