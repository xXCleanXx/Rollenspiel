package com.roleplay.characters;

import com.roleplay.tools.ImageUtils;

public class Wizard extends Character {
    public Wizard(CharacterProperties characterProperties) {
        super(characterProperties);
        getProperties().setName("wizard");
        getProperties().setDisplayName("Wizard");

        getProperties().setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/player/wizard1_32x32.png"));
        getProperties().setTexture100(ImageUtils.loadImage("src/com/roleplay/resources/images/player/wizard1_100x100.png"));
        getProperties().setTexture300(ImageUtils.loadImage("src/com/roleplay/resources/images/player/wizard1_300x300.png"));

    }
}