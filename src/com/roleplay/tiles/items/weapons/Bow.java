package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class Bow extends Weapon {
    protected Bow() {
        super("bow", 2, 8);
        setImg(Image.loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        Bow bow = new Bow();
        bow.setPosition(getPosition());
        bow.setDisplayName(getDisplayName());

        return bow;
    }
}