package com.roleplay.tiles.properties;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class TileProperties {
    private String name;
    private Point position;
    private BufferedImage texture;

    public TileProperties(String name, Point position, BufferedImage texture){
        setName(name);
        setPosition(position);
        setTexture(texture);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setTexture(BufferedImage texture) {
        if(texture == null){
            throw new IllegalArgumentException("texture can't be null");
        }

        this.texture = texture;
    }

    public BufferedImage getTexture() {
        return texture;
    }
}
