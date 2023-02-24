package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

import java.awt.*;

public class Axe extends Weapon {
    public Axe() {
        super("axe", 2, 6);
        setImg(Image.loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        return new Axe();
    }
}