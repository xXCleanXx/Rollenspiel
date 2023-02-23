package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;

public class Axe extends Weapon {
    public Axe() {
        super("axe", 2, 6);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        Axe axe = new Axe();
        axe.setPosition(getPosition());
        axe.setDisplayName(getDisplayName());

        return axe;
    }
}