package com.roleplay.tiles.characters;

import com.roleplay.tiles.properties.CharacterProperties;

public class Wizard extends Character {
    public Wizard(CharacterProperties characterProperties) {
        super(characterProperties);
        getProperties().setName("Wizard");
    }
}