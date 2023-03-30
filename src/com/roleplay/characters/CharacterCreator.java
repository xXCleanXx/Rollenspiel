package com.roleplay.characters;

import com.roleplay.characters.enums.Directions;
import com.roleplay.characters.enums.Races;
import com.roleplay.items.BookOfSpells;
import com.roleplay.items.CristalBall;
import com.roleplay.items.Inventory;
import com.roleplay.items.ItemProperties;
import com.roleplay.items.armors.ChainArmor;
import com.roleplay.items.armors.LeatherArmor;
import com.roleplay.items.armors.Shield;
import com.roleplay.items.weapons.*;

import java.util.Random;

public class CharacterCreator {
    public CharacterCreator(Character character, Races race, String name) {
        CharacterProperties characterProperties = character.getProperties();

        characterProperties.setDisplayName(name);
        characterProperties.setRace(race);

        characterProperties.setAbilities(new Abilities());
        characterProperties.setInventory(new Inventory(15));

        if (character instanceof Warrior) {
            abilitiesModifier(characterProperties, 10);

            switch (new Random().nextInt(3)) {
                case 0 -> {
                    characterProperties.getInventory().add(new ChainArmor(new ItemProperties()));
                    characterProperties.getInventory().add(new Bow(new ItemProperties()));
                }
                case 1 -> {
                    characterProperties.getInventory().add(new Sword(new ItemProperties()));
                    characterProperties.getInventory().add(new Shield(new ItemProperties()));
                }
                case 2 -> {
                    characterProperties.getInventory().add(new HandAxe(new ItemProperties()));
                    characterProperties.getInventory().add(new HandAxe(new ItemProperties()));
                }
            }
        } else if (character instanceof Wizard) {
            abilitiesModifier(characterProperties, 8);
            characterProperties.getInventory().add(new Dagger(new ItemProperties()));
            characterProperties.getInventory().add(new BookOfSpells(new ItemProperties()));
            characterProperties.getInventory().add(new CristalBall(new ItemProperties()));
        } else if (character instanceof Thief) {
            abilitiesModifier(characterProperties, 8);
            characterProperties.getInventory().add(new LeatherArmor(new ItemProperties()));
            characterProperties.getInventory().add(new Dagger(new ItemProperties()));
            characterProperties.getInventory().add(new Dagger(new ItemProperties()));
            characterProperties.getInventory().add(new Bow(new ItemProperties()));
            characterProperties.getInventory().add(new Spear(new ItemProperties()));
        } else if (character instanceof Monster) {
            abilitiesModifier(characterProperties, 8);
        }

        addAbilities(characterProperties, race);
        characterProperties.setDirection(Directions.EAST);
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
        if (race == Races.DWARF) {
            characterProperties.getAbilities().addAbilities(0, 2, 2, 1, 0);
        } else if (race == Races.HUMAN) {
            characterProperties.getAbilities().addAbilities(1, 1, 1, 1, 1);
        } else if (race == Races.ELF) {
            characterProperties.getAbilities().addAbilities(2, 0, 0, 1, 2);
        } else if (race == Races.HOBBIT) {
            characterProperties.getAbilities().addAbilities(0, 0, 1, 2, 2);
        }
    }


}
