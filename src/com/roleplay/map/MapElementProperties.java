package com.roleplay.map;

import com.roleplay.HitBox;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapElementProperties extends TileProperties {
    private final HitBox hitbox;

    public MapElementProperties(String name, Point position, BufferedImage texture) {
        super(name, position, texture);
        hitbox = new HitBox(32,32);
    }

    public MapElementProperties(Point position, BufferedImage texture){
        super(position, texture);
        hitbox = new HitBox(32,32);

    }

    public HitBox getHitBox() {
        return hitbox;
    }
}