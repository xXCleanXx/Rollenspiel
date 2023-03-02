package com.roleplay.tiles.characters;

public class Monster extends Character {
    protected Monster(CharacterBuilder builder) {
        super(builder);
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
