package com.roleplay.build;

import com.roleplay.map.Tile;
import com.roleplay.map.MapElementProperties;

import java.awt.image.BufferedImage;

public class GameMap {
    private int width;
    private int height;
    private int tileSize;

    private Tile<MapElementProperties>[][] map;

    public GameMap(int width, int height, int tileSize) {
        setWidth(width);
        setHeight(height);
        setTileSize(tileSize);

        map = new Tile<>[width][height];
    }

    public int getWidth() {
        return width;
    }

    private void setWidth(int width) {
        if (width <= 0) throw new IllegalArgumentException("Width cannot be less or equals than 0!");

        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        if (height <= 0) throw new IllegalArgumentException("Height cannot be less or equals than 0!");

        this.height = height;
    }

    public int getTileSize() {
        return tileSize;
    }

    private void setTileSize(int tileSize) {
        if (tileSize <= 0) throw new IllegalArgumentException("Tile size cannot be less or equals than 0!");

        this.tileSize = tileSize;
    }

    public BufferedImage getMap() {
        //BufferedImage img = new BufferedImage(tileSize * columns, tileSize * rows, BufferedImage.TYPE_INT_ARGB);

        return null;
    }

    public Tile<MapElementProperties>[][] getMapElements() {
        return map;
    }
}