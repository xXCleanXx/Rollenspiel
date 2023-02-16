package com.roleplay.tests.character;

import com.roleplay.characters.Abilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbilitiesTests {
    @Test
    public void AbilitiesTest() {
        Abilities abilities = new Abilities();

        assertDoesNotThrow(() ->
            abilities.setConstitution(5)
                    .setExperience(6)
                    .setIntelligence(10)
                    .setSkill(9)
                    .setWisdom(8)
                    .setStrength(5)
        );

        assertEquals(abilities.getConstitution(), 5);
        assertEquals(abilities.getExperience(), 6);
        assertEquals(abilities.getIntelligence(), 10);
        assertEquals(abilities.getSkill(), 9);
        assertEquals(abilities.getWisdom(), 8);
        assertEquals(abilities.getStrength(), 5);

        assertThrows(IllegalArgumentException.class, () ->
                abilities.setConstitution(-2)
        );

        assertThrows(IllegalArgumentException.class, () ->
                abilities.setExperience(-2)
        );

        assertThrows(IllegalArgumentException.class, () ->
                abilities.setIntelligence(-2)
        );

        assertThrows(IllegalArgumentException.class, () ->
                abilities.setSkill(-2)
        );

        assertThrows(IllegalArgumentException.class, () ->
                abilities.setWisdom(-2)
        );

        assertThrows(IllegalArgumentException.class, () ->
                abilities.setStrength(-2)
        );
    }
}