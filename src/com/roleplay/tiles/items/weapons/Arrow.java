package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

import java.awt.*;

public class Arrow extends Item {
    public Arrow(ItemProperties itemProperties) {
        super(itemProperties);
    }

    @Override
    public Item clone() {
        Arrow arrow = new Arrow((ItemProperties) getProperties());

        clone(arrow, this);

        return arrow;
    }
}