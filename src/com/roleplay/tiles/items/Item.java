package com.roleplay.tiles.items;

import com.roleplay.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Item extends Tile implements Cloneable {
    private String displayName;
    private double weight;

    public Item(String name, double weight, Point pos) {
        super(name, pos);
        setName(name);
        setWeight(weight);
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

    private void setWeight(double weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be less than 0!");

        this.weight = weight;
    }

    @Override
    public abstract Item clone();
}