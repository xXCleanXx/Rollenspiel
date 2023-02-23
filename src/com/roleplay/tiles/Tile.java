package com.roleplay.tiles;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tile {

    public int id;
    public Point pos;
    public BufferedImage img;

    public Tile(int id, Point pos, BufferedImage img){
        setId(id);
        setPos(pos);
        setImg(img);
    }

    public Tile(int id, Point pos){
        setId(id);
        setPos(pos);
    }

    public Tile(){

    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
