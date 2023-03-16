package com.roleplay.items;

import com.roleplay.map.Tile;

public abstract class Item extends Tile<ItemProperties> {

    public Item(ItemProperties itemProperties) {
        super(itemProperties);
    }
}