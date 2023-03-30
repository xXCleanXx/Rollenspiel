package com.roleplay.characters;

import com.roleplay.tools.ImageUtils;

public class Monster extends Character {
    public Monster(CharacterProperties characterProperties) {
        super(characterProperties);

        getProperties().setName("monster");
        getProperties().setDisplayName("Monster");
        getProperties().setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/player/monster_32x32.png"));
        getProperties().setTexture100(ImageUtils.loadImage("src/com/roleplay/resources/images/player/monster_100x100.png"));
        getProperties().setTexture300(ImageUtils.loadImage("src/com/roleplay/resources/images/player/monster_300x300.png"));

    }
}