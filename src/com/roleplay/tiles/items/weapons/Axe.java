package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class Axe extends Weapon {
    public Axe(String name, double damage, Point pos) {
        super(name, 2, damage, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        return new Axe(getName(), getDamage(), getPos());
    }
}