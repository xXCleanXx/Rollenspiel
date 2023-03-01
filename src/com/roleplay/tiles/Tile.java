package com.roleplay.tiles;

import com.roleplay.tiles.properties.TileProperties;

public class Tile {

    private TileProperties properties;

    public Tile(TileProperties properties) {
        setProperties(properties);
    }

    public void setProperties(TileProperties properties) {
        this.properties = properties;
    }

    public TileProperties getProperties() {
        return properties;
    }
}
