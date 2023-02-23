package com.roleplay.tiles.items;

import com.roleplay.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Item extends Tile implements Cloneable {
    private String name, displayName;
    private double weight;

    public Item(String name, double weight, int id, Point pos) {
        super(id, pos);
        setName(name);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
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

    public BufferedImage loadImage(String pathname){
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(pathname));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return img;
    }

    @Override
    public abstract Item clone();
}