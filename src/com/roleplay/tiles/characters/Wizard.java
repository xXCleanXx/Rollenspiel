package com.roleplay.tiles.characters;

import com.roleplay.tiles.properties.CharacterProperties;

public class Wizard extends Character {
    public Wizard(CharacterProperties characterProperties) {
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
