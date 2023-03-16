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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be less than 0!");

        this.weight = weight;
    }
}