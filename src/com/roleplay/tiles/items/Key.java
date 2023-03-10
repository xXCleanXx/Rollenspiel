package com.roleplay.tiles.items;

import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.ImageUtils;

import java.awt.*;

public class Key extends Item {
    public Key() {
        super(new ItemProperties("key", new Point(0,0), ImageUtils.loadImage("")));
    }
}