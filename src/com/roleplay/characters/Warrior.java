package com.roleplay.characters;

import com.roleplay.tools.ImageUtils;

public class Warrior extends Character {
    public Warrior(CharacterProperties characterProperties) {
        super(characterProperties);
        getProperties().setName("Warrior");
        getProperties().setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/player/fighter1_32x32.png"));
        getProperties().setTexture100(ImageUtils.loadImage("src/com/roleplay/resources/images/player/fighter1_100x100.png"));
        getProperties().setTexture300(ImageUtils.loadImage("src/com/roleplay/resources/images/player/fighter1_300x300.png"));
    }
}