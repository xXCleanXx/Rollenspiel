package com.roleplay.effects;

import com.roleplay.characters.Character;

public class HealEffect extends Effect {
    private double healthPoints;

    public HealEffect(double healthPoints) {
        setHealthPoints(healthPoints);
    }

    private void setHealthPoints(double healthPoints) {
        if (healthPoints < 0) throw new IllegalArgumentException("Health points cannot be less than 0!");

        this.healthPoints = healthPoints;
    }

    public void apply(Character character) {
        if (character == null) throw new IllegalArgumentException("Character cannot be null!");

        character.getProperties().setHealthPoints(healthPoints);
    }
}