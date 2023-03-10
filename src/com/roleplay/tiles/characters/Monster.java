package com.roleplay.tiles.characters;

import com.roleplay.tiles.properties.CharacterProperties;

public class Monster extends Character {
    protected Monster(CharacterProperties characterProperties) {
        super(characterProperties);
        getProperties().setName("Monster");
    }
}