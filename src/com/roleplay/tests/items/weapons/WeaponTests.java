package com.roleplay.tests.items.weapons;

import com.roleplay.items.weapons.Axe;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WeaponTests {
    @Test
    public void AxeTests() {
        assertThrows(IllegalArgumentException.class, () -> new Axe(null, 0));
        assertThrows(IllegalArgumentException.class, () -> new Axe("", -1));

        Axe axe = new Axe("axe", 10);
        axe.setDisplayName("Test Axe");

        assertEquals("Test Axe", axe.getDisplayName());
        assertEquals(10, axe.getDamage());
        assertEquals("axe", axe.getName());
    }

    @Test
    public void DaggerTests() {

    }
}