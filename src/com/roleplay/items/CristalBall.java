package com.roleplay.items;

import com.roleplay.tools.ImageUtils;

/***
 * Cristal ball item.
 */
public class CristalBall extends Item {
    public CristalBall(ItemProperties itemProperties) {
        super(itemProperties);
        itemProperties.setName("cristalBall");
        itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/cristal_ball_32x32.png"));
    }
}