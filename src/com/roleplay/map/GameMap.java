package com.roleplay.map;

import com.roleplay.characters.Monster;
import com.roleplay.items.Item;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    public static final int TILE_SIZE = 32;
    private final Tile<?>[][] map;
    private final List<Item> items = new ArrayList<>();
    private final List<Monster> _monsters = new ArrayList<>();
    private Settings settings;

    public GameMap(int width, int height) {
        setWidth(width);
        setHeight(height);

        map = new Tile[height][width];
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null!");

        items.add(item);
    }

    public void removeItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null!");

        items.remove(item);
    }

    public List<Monster> getMonsters() {
        return _monsters;
    }

    public void addMonster(Monster monster) {
        if (monster == null) throw new IllegalArgumentException("Monster cannot be null!");

        _monsters.add(monster);
    }

    public void removeMonster(Monster monster) {
        if (monster == null) throw new IllegalArgumentException("Monster cannot be null!");

        _monsters.remove(monster);
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

    public BufferedImage getMap() {
        BufferedImage img = new BufferedImage(TILE_SIZE * getWidth(), TILE_SIZE * getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                final BufferedImage tile = getMapElements()[i][j].getProperties().getTexture32();

                if (tile == null) continue;

                for (int y = 0; y < tile.getHeight(); y++) {
                    for (int x = 0; x < tile.getWidth(); x++) {
                        img.setRGB(x + j * TILE_SIZE, y + i * TILE_SIZE, tile.getRGB(x, y));
                    }
                }
            }
        }

        return img;
    }

    public Tile<?>[][] getMapElements() {
        return map;
    }
}