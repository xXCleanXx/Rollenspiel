package com.roleplay.tiles.characters;

import com.roleplay.tiles.properties.CharacterProperties;

public class Thief extends Character {
    public Thief(CharacterProperties properties) {
        super(properties);
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