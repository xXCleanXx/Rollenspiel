package com.roleplay.tiles.characters;

import com.roleplay.tiles.items.armors.Armor;
import com.roleplay.tiles.properties.CharacterProperties;

public class Warrior extends Character {
    public Warrior(CharacterProperties characterProperties) {
        super(characterProperties);
        getProperties().setName("Warrior");
    }
}