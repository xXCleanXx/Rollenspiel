package com.roleplay.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Door extends Tile {
    private boolean locked, open;
    private Key key;

    public Door(int id, Point pos, BufferedImage img){
        super(id,pos,img);
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