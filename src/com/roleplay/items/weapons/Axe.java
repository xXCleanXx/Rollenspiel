package com.roleplay.items.weapons;

import com.roleplay.items.weapons.abstractions.Weapon;
import org.jetbrains.annotations.NotNull;

public class Axe extends Weapon {
    public Axe(@NotNull String name, double damage) {
        super(name, damage);
    }
}
