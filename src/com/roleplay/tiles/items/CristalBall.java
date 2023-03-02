package com.roleplay.tiles.items;

import com.roleplay.tools.Image;

/***
 * Cristal ball item.
 */
public class CristalBall extends Item {
    public CristalBall() {
        super("cristal_ball", 0);
        loadTexture("src/com/roleplay/resources/images/gras.png");
    }

    @Override
    public Item clone() {
        CristalBall cristalBall = new CristalBall();

        clone(cristalBall, this);

        return cristalBall;
    }
}
