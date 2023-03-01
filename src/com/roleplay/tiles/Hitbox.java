package com.roleplay.tiles;

import java.awt.*;

public class Hitbox {

    private Point position;
    private int width;
    private int height;

    private boolean enabled = true;

    public Hitbox(Point position, int width, int height){
        setPosition(position);
        setWidth(width);
        setHeight(height);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
