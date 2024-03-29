package com.roleplay.effects;

import com.roleplay.tiles.characters.Character;

public class HealEffect extends Effect {
    private double healthPoints;

    public HealEffect(double healthPoints) {
        setHealthPoints(healthPoints);
    }

    private void setHealthPoints(double healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException("Health points cannot be less than 0!");
        }

        this.healthPoints = healthPoints;
    }

    public void apply(Character character) {
        character.setHealthPoints(healthPoints);
    }
}