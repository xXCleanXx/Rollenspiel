package com.roleplay.map;

import com.roleplay.HitBox;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameMapElementProperties extends TileProperties {
    private final HitBox hitbox;

    public GameMapElementProperties(String name, Point position, BufferedImage texture) {
        super(name, position, texture);
        hitbox = new HitBox(32, 32);
    }

    public GameMapElementProperties(Point position) {
        super(position);
        hitbox = new HitBox(32, 32);

    }

    public HitBox getHitBox() {
        return hitbox;
    }
}