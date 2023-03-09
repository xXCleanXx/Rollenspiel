package com.roleplay.tiles.items;

import com.roleplay.tiles.Tile;
import com.roleplay.tiles.properties.ItemProperties;

public abstract class Item extends Tile {

    public Item(ItemProperties itemProperties) {
        super(itemProperties);
    }
}