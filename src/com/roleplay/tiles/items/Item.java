package com.roleplay.tiles.items;

import com.roleplay.tiles.Tile;
import com.roleplay.tiles.properties.ItemProperties;

public abstract class Item extends Tile implements Cloneable {

    public Item(ItemProperties itemProperties) {
        super(itemProperties);
    }

    @Override
    public abstract Item clone();

    public static void clone(Item newItem, Item oldItem) {
        newItem.getProperties().setPosition(oldItem.getProperties().getPosition());
        ((ItemProperties)newItem.getProperties()).setDisplayName(((ItemProperties)oldItem.getProperties()).getDisplayName());
    }
}