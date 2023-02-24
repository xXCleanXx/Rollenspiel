package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class Dagger extends Weapon {
    public Dagger() {
        super("dagger", 2, 4);
        setImg(Image.loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        Dagger dagger = new Dagger();
        dagger.setPosition(getPosition());
        dagger.setDisplayName(getDisplayName());

        return dagger;
    }
}