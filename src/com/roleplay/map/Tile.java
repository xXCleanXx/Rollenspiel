package com.roleplay.map;

public class Tile<T extends TileProperties> {
    private T properties;

    public Tile(T properties) {
        setProperties(properties);
    }

    protected void setProperties(T properties) {
        if (properties == null) throw new IllegalArgumentException("Properties cannot be null!");

        this.properties = properties;
    }

    public T getProperties() {
        return properties;
    }

    public MapElementProperties getMapElementProperties(){
        return (MapElementProperties) properties;
    }

}
