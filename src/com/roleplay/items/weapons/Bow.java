package com.roleplay.items.weapons;

import com.roleplay.items.weapons.abstractions.Weapon;
import org.jetbrains.annotations.NotNull;

public class Bow extends Weapon {
    protected Bow(@NotNull String name, double damage) {
        super(name, damage);
    }
}