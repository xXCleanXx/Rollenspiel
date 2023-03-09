package com.roleplay.tiles.characters;

import com.roleplay.tiles.items.armors.Armor;
import com.roleplay.tiles.properties.CharacterProperties;

public class Warrior extends Character {
    public Warrior(CharacterProperties characterProperties) {
        super(characterProperties);
        getProperties().setName("Warrior");
    }

    @Override
    public double attack(Character enemy) {
        return 0;
    }

    @Override
    public double defend() {
        Armor armor = ((CharacterProperties)getProperties()).getInventory().getArmor();

        return armor != null ? armor.getStrength() : 0;
    }
}