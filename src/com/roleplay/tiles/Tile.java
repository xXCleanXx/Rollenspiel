package com.roleplay.tiles;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tile {

    private String name;
    private Point pos;
    private BufferedImage img;

    public Tile(String name, Point pos, BufferedImage img) {
        setName(name);
        setPos(pos);
        setImg(img);
    }

    public Tile(String name, Point pos) {
        setName(name);
        setPos(pos);
    }

    public Tile(String name) {
        setName(name);
    }

    public Tile() {

    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
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

    public BufferedImage loadImage(String pathname) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(pathname));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return img;
    }
}
