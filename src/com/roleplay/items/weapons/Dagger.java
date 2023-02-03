package com.roleplay.items.weapons;

import com.roleplay.items.weapons.abstractions.Weapon;
import org.jetbrains.annotations.NotNull;

public class Dagger extends Weapon {
    public Dagger(@NotNull String name, double damage) {
        super(name, damage);
    }
}