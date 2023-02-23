package com.roleplay.tests.items.weapons;

import com.roleplay.tiles.items.weapons.Axe;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WeaponTests {
    @Test
    public void AxeTests() {
        assertThrows(IllegalArgumentException.class, () -> new Axe(null, 0, null));
        assertThrows(IllegalArgumentException.class, () -> new Axe("", -1, null));

        Axe axe = new Axe("axe", 10, null);
        axe.setDisplayName("Test Axe");

        assertEquals("Test Axe", axe.getDisplayName());
        assertEquals(10, axe.getDamage());
        assertEquals("axe", axe.getName());
    }

    @Test
    public void DaggerTests() {

    }
}