package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class Bow extends Weapon {
    protected Bow(String name, double damage, Point pos) {
        super(name, 2, damage, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        return new Bow(getName(), getDamage(), pos);
    }
}