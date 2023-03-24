package com.roleplay.items.weapons;

import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Dart extends Weapon {

    protected Dart(ItemProperties itemProperties) {
        super(itemProperties, 4);
        itemProperties.setName("dart");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/dart_32x32.png"));
    }
}
