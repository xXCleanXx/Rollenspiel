package com.roleplay.tiles;

import com.roleplay.tiles.items.Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Door extends Tile {
    private boolean locked, open;
    private Key key;

    public Door(String name, Point pos, BufferedImage img){
        super(name,pos);
        setImg(img);
    }

    public Door(String name, Point pos){
        super(name,pos);
        setImg(loadImage("src/com/roleplay/resources/images/door.png"));
    }

    public boolean isOpen() {
        return open;
    }

    public void close() {
        open = false;
    }

    public void open() {
        open = true;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean lock(Key key) {
        if (isOpen() || isLocked()) return false;

        this.key = key;

        return locked = true;
    }

    public boolean unlock(Key key) {
        if (!key.getName().equalsIgnoreCase(this.key.getName())) return false;

        locked = false;

        return true;
    }
}