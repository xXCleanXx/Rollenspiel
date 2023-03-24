package com.roleplay.items;

import com.roleplay.tools.ImageUtils;

import java.awt.*;

public class Key extends Item {
    public Key(ItemProperties itemProperties) {
        super(itemProperties);
        getProperties().setName("key");
    }
}