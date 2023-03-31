package com.roleplay.items.weapons;

import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

public class Dart extends ThrowableWeapon {

    public Dart(ItemProperties itemProperties) {
        super(itemProperties, 4, 2);
        itemProperties.setName("dart");
        itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/dart_32x32.png"));
    }
}
