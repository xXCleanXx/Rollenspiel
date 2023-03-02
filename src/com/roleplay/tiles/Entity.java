package com.roleplay.tiles;

import java.awt.*;

public class Entity extends Tile {
    private Rectangle hitBox;
    private boolean canCollide = true;

    public Entity(String name, boolean canCollide) {
        super(name);

        collidable(canCollide);

        hitBox = new Rectangle(getPosition().x, getPosition().y, 32, 32);
    }

    public Entity(String name) {
        this(name, true);
    }

    protected void collidable(boolean flag) {
        canCollide = flag;
    }

    public boolean canCollide() {
        return canCollide;
    }

    public Rectangle getHitBox(){
        return this.hitBox;
    }

    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }

    public boolean collusionDetected(Rectangle a, Rectangle b){
        return canCollide && !a.intersects(b);
    }
}
