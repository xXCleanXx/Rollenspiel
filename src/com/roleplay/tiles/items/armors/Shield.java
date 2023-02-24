package com.roleplay.tiles.items.armors;

import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class Shield extends Item {
    public Shield() {
        super("shield", 6);
        setImg(Image.loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    public double getStrength() {
        return 2;
    }

    @Override
    public Item clone() {
        Shield shield = new Shield();
        shield.setPosition(getPosition());
        shield.setDisplayName(getDisplayName());

        return shield;
    }
}