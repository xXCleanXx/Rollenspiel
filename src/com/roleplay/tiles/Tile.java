package com.roleplay.tiles;

import com.roleplay.tiles.properties.TileProperties;

public class Tile<T extends TileProperties> {
    private T properties;

    public Tile(T properties) {
        setProperties(properties);
    }

    public void setProperties(T properties) {
        this.properties = properties;
    }

    public T getProperties() {
        return properties;
    }

}
