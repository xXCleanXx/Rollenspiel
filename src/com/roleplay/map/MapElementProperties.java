package com.roleplay.map;

import com.roleplay.Hitbox;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapElementProperties extends TileProperties {
    private final Hitbox hitbox;

    public MapElementProperties(String name, Point position, BufferedImage texture) {
        super(name, position, texture);

        hitbox = new Hitbox(32,32);
    }

    public MapElementProperties(Point position, BufferedImage texture) {
        this("", position, texture);
    }

    public Hitbox getHitbox() {
        return hitbox;
    }
}