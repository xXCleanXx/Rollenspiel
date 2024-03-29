package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class Dart extends Weapon {

    protected Dart() {
        super("dart", 0.25, 4);
        loadTexture("src/com/roleplay/resources/images/gras.png");
    }

    @Override
    public Item clone() {
        Dart dart = new Dart();

        clone(dart, this);

        return dart;
    }
}
