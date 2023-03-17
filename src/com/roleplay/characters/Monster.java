package com.roleplay.characters;

public class Monster extends Character {
    protected Monster(CharacterProperties characterProperties) {
        super(characterProperties);

        getProperties().setName("Monster");
    }
}