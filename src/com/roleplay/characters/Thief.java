package com.roleplay.characters;

import com.roleplay.tools.ImageUtils;

public class Thief extends Character {
    public Thief(CharacterProperties properties) {
        super(properties);
        getProperties().setName("Thief");
        getProperties().setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/player/fighter2_32x32.png"));
        getProperties().setTexture100(ImageUtils.loadImage("src/com/roleplay/resources/images/player/fighter2_100x100.png"));
        getProperties().setTexture300(ImageUtils.loadImage("src/com/roleplay/resources/images/player/fighter2_300x300.png"));
    }
}