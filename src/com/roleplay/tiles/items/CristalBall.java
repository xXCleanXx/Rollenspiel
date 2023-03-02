package com.roleplay.tiles.items;

import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

/***
 * Cristal ball item.
 */
public class CristalBall extends Item {
    public CristalBall(ItemProperties itemProperties) {
        super(itemProperties);
    }

    @Override
    public Item clone() {
        CristalBall cristalBall = new CristalBall((ItemProperties) getProperties());

        clone(cristalBall, this);

        return cristalBall;
    }
}
