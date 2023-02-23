package com.roleplay.tiles.items;

import java.awt.*;

public class CristalBall extends Item{
    public CristalBall(String name, Point pos) {
        super(name, 0, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        return new CristalBall(getName(), getPos());
    }
}
