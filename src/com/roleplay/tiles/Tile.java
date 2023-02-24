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
    private Rectangle hitBox;

    public Tile(String name, Point pos, BufferedImage img, boolean withHitbox) {
        setName(name);
        setPosition(pos);
        setImg(img);

        if (withHitbox) {
            setHitBox(new Rectangle(getPosition().x, getPosition().y, 32, 32));
        }

    }

    public Tile(String name, Point pos, BufferedImage img) {
        this(name, pos, img, true);

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

    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }

    public Rectangle getHitBox() {
        return this.hitBox;
    }

    public boolean collusionDetected(Rectangle a, Rectangle b) {
        if (a == null || (a != null && !a.intersects(b)))
            return true;
        else
            return false;
    }
}
