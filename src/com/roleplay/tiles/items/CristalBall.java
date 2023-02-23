package com.roleplay.tiles.items;

/***
 * Cristal ball item.
 */
public class CristalBall extends Item {
    public CristalBall() {
        super("cristal_ball", 0);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public Item clone() {
        CristalBall cristallBall = new CristalBall();
        cristallBall.setPosition(getPosition());
        cristallBall.setDisplayName(getDisplayName());

        return cristallBall;
    }
}
