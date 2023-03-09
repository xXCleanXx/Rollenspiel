package com.roleplay.tiles.characters;

import com.roleplay.tiles.properties.CharacterProperties;

public class Monster extends Character {
    protected Monster(CharacterProperties characterProperties) {
        super(characterProperties);
        getProperties().setName("Monster");
    }

    @Override
    public double attack(Character enemy) {
        return 0;
    }

    @Override
    public double defend() {
        return 0;
    }
}