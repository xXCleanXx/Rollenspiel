package com.roleplay.tiles.characters;

import com.roleplay.tiles.characters.enums.Directions;
import com.roleplay.tiles.properties.CharacterProperties;

public class CharacterCreator {

    public CharacterCreator(Character character) {
        CharacterProperties characterProperties = (CharacterProperties) character.getProperties();

        characterProperties.setAbilities(new Abilities());

        if (character.getClass() == Warrior.class) {
            characterProperties.setHealthPoints(10);
        } else if (character.getClass() == Wizard.class) {
            characterProperties.setHealthPoints(8);
        } else if (character.getClass() == Thief.class) {
            characterProperties.setHealthPoints(8);
        }




        characterProperties.setDirection(Directions.WEST);
    }

}
