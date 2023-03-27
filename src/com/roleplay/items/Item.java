package com.roleplay.items;

import com.roleplay.map.GameMap;
import com.roleplay.map.Tile;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class Item extends Tile<ItemProperties> {

    public Item(ItemProperties itemProperties) {
        super(itemProperties);
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                getProperties().getTexture32(),
                getProperties().getPosition().x * GameMap.TILE_SIZE,
                getProperties().getPosition().y * GameMap.TILE_SIZE,
                observer
        );
    }
}