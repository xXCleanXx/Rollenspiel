package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;

import java.awt.*;

public class Dart extends Weapon {

    protected Dart(String name, double damage, Point pos) {
        super(name, 0.25, damage, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        return new Dart(getName(), getDamage(), getPos());
    }
}
