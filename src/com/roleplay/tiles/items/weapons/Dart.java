package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;

public class Dart extends Weapon {

    protected Dart() {
        super("dart", 0.25, 4);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        Dart dart = new Dart();
        dart.setPosition(getPosition());
        dart.setDisplayName(getDisplayName());

        return dart;
    }
}
