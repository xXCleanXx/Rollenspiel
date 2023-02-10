package com.roleplay.items;

public class CristalBall extends Item{
    public CristalBall(String name) {
        super(name, 0);
    }

    @Override
    public Item clone() {
        return new CristalBall(getName());
    }
}
