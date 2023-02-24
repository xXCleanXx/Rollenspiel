package com.roleplay.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    private String name;
    private Point pos;
    private BufferedImage img;

    public Tile(String name, Point pos, BufferedImage img) {
        setName(name);
        setPosition(pos);
        setImg(img);
    }

    public Tile(String name, Point pos) {
        setName(name);
        setPosition(pos);
    }

    public Tile(String name) {
        setName(name);
    }

    public Tile() {

    }

    public Point getPosition() {
        return pos;
    }

    public void setPosition(Point pos) {
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

}
