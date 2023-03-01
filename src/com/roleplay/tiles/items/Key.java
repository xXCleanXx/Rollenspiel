package com.roleplay.tiles.items;

import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

import java.awt.*;

public class Key extends Item {

    public Key() {
        super(new ItemProperties("key", new Point(0,0), Image.loadImage("")));
    }

    @Override
    public Item clone() {
        Key key = new Key();

        clone(key, this);

        return key;
    }
}