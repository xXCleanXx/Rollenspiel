package com.roleplay.tests.items.weapons;

import com.roleplay.tiles.items.weapons.Axe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeaponTests {
    @Test
    public void AxeTests() {
        assertThrows(IllegalArgumentException.class, () -> new Axe());
        assertThrows(IllegalArgumentException.class, () -> new Axe());

        Axe axe = new Axe();
        axe.setDisplayName("Test Axe");

        assertEquals("Test Axe", axe.getDisplayName());
        assertEquals(10, axe.getDamage());
        assertEquals("axe", axe.getName());
    }

    @Test
    public void DaggerTests() {

    }
}