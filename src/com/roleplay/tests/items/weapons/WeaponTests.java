package com.roleplay.tests.items.weapons;

import com.roleplay.tiles.items.weapons.Axe;
import com.roleplay.tiles.properties.ItemProperties;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeaponTests {
    @Test
    public void AxeTests() {
        assertThrows(IllegalArgumentException.class, () -> new Axe(new ItemProperties("axe", new Point(0,0), null), 10));
        assertThrows(IllegalArgumentException.class, () -> new Axe(new ItemProperties("axe", new Point(0,0), null), 10));

        Axe axe = new Axe(new ItemProperties("axe", new Point(0,0), null), 10);
        ((ItemProperties) axe.getProperties()).setDisplayName("Test Axe");

        assertEquals("Test Axe", ((ItemProperties) axe.getProperties()).getDisplayName());
        assertEquals(10, axe.getDamage());
        assertEquals("axe", axe.getProperties().getName());
    }

    @Test
    public void DaggerTests() {

    }
}