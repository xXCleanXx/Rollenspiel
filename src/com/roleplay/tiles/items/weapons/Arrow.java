package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

import java.awt.*;

public class Arrow extends Item {
    public Arrow() {
        super("arrow", 0);
        setImg(Image.loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        return new Arrow();
    }
}