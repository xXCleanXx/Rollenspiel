package com.roleplay.tiles.characters;

import com.roleplay.tiles.properties.CharacterProperties;

public class Monster extends Character {
    protected Monster(CharacterProperties characterProperties) {
        super(characterProperties);
    }

    @Override
    public double attack(Character enemy) {
        return 0;
    }

    @Override
    public double defend() {
        return 0;
    }

    @Override
    public void levelUp() {

    }
}
