package com.roleplay.tiles;

import com.roleplay.tools.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    private String name, displayName;
    private Point position = new Point();
    private BufferedImage image;

    public Tile(String name) {
        setName(name);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setTexture(BufferedImage image) {
        //if (image == null) throw new IllegalArgumentException("Image cannot be null!");

        this.image = image;
    }

    public void loadTexture(String imagePath) {
        setTexture(Image.loadImage(imagePath));
    }
}
