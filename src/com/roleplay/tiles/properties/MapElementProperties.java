package com.roleplay.tiles.properties;

import com.roleplay.tiles.Hitbox;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapElementProperties extends TileProperties{

    private Hitbox hitbox;

    public MapElementProperties(String name, Point position, BufferedImage texture) {
        super(name, position, texture);

        hitbox = new Hitbox(32,32);
    }

    public Hitbox getHitbox() {
        return hitbox;
    }
}