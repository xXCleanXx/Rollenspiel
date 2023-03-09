package com.roleplay.tiles.characters;

import com.roleplay.tiles.characters.enums.Directions;
import com.roleplay.tiles.characters.enums.Races;
import com.roleplay.tiles.properties.CharacterProperties;

public class CharacterCreator {
    public CharacterCreator(Character character, Races race, String name) {
        CharacterProperties characterProperties = character.getProperties();

        characterProperties.setDisplayName(name);

        characterProperties.setAbilities(new Abilities());

        if (character.getClass() == Warrior.class) {
            abilitiesModifier(characterProperties, 10);
        } else {
            abilitiesModifier(characterProperties, 8);
        }

        addAbilities(characterProperties, race);
        characterProperties.setDirection(Directions.WEST);
    }

    private void abilitiesModifier(CharacterProperties characterProperties, int healthPoints) {
        Abilities abilities = characterProperties.getAbilities();
        healthPoints = (int) (healthPoints + (abilities.getIntelligence() - 10) / 2);
        healthPoints = (int) (healthPoints + (abilities.getStrength() - 10) / 2);
        healthPoints = (int) (healthPoints + (abilities.getConstitution() - 10) / 2);
        healthPoints = (int) (healthPoints + (abilities.getWisdom() - 10) / 2);
        healthPoints = (int) (healthPoints + (abilities.getSkill() - 10) / 2);

        characterProperties.setHealthPoints(healthPoints);
    }

    private void addAbilities(CharacterProperties characterProperties, Races race) {
        if (Races.DWARF.equals(race)) {
            characterProperties.getAbilities().addAbilities(0, 2, 2, 1, 0);
        } else if (Races.HUMAN.equals(race)) {
            characterProperties.getAbilities().addAbilities(1, 1, 1, 1, 1);
        } else if (Races.ELF.equals(race)) {
            characterProperties.getAbilities().addAbilities(2, 0, 0, 1, 2);
        } else if (Races.HOBBIT.equals(race)) {
            characterProperties.getAbilities().addAbilities(0, 0, 1, 2, 2);
        }
    }


}
