package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class Bow extends Weapon {
    protected Bow() {
        super("bow", 2, 8);
        loadTexture("src/com/roleplay/resources/images/gras.png");
    }

    @Override
    public Item clone() {
        Bow bow = new Bow();

        clone(bow, this);

        return bow;
    }
}