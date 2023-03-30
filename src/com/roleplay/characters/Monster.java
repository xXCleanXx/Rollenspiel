package com.roleplay.characters;

public class Monster extends Character {
    public Monster(CharacterProperties characterProperties) {
        super(characterProperties);

        getProperties().setName("monster");
        getProperties().setDisplayName("Monster");
    }
}