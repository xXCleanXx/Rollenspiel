package com.roleplay.map;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class TileProperties {
    private String name;
    private Point position;
    private BufferedImage texture32;
    private BufferedImage texture100;
    private BufferedImage texture300;

    public TileProperties(String name, Point position, BufferedImage texture){
        setName(name);
        setPosition(position);
        setTexture32(texture);
    }

    public TileProperties(Point position){
        setPosition(position);
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

    public void setTexture32(BufferedImage texture) {
        if(texture == null){
            throw new IllegalArgumentException("texture can't be null");
        }

        this.texture32 = texture;
    }

    public void setTexture100(BufferedImage texture) {
        if(texture == null){
            throw new IllegalArgumentException("texture can't be null");
        }

        this.texture100 = texture;
    }

    public void setTexture300(BufferedImage texture) {
        if(texture == null){
            throw new IllegalArgumentException("texture can't be null");
        }

        this.texture300 = texture;
    }

    public BufferedImage getTexture32() {
        return texture32;
    }

    public BufferedImage getTexture100() {
        return texture100;
    }

    public BufferedImage getTexture300() {
        return texture300;
    }
}