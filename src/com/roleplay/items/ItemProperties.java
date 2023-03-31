package com.roleplay.items;

import com.roleplay.map.TileProperties;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ItemProperties extends TileProperties {
    private String displayName;
    private double weight;

    public ItemProperties(String name, Point position, BufferedImage texture) {
        super(name, position, texture);
    }

    public ItemProperties(Point position) {
        super(position);
    }
    public ItemProperties(String name) {
        super(name);
    }

    public ItemProperties() {
        super();
    }
}