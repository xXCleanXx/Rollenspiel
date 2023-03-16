package com.roleplay.effects;


import com.roleplay.characters.Character;

public class DamageEffect extends Effect {
    private double damage;

    public DamageEffect(double damage) {
        setDamage(damage);
    }

    private void setDamage(double damage) {
        if (damage > 0) damage *= -1;

        this.damage = damage;
    }

    @Override
    public void apply(Character character) {
        if (character == null) throw new IllegalArgumentException("Character cannot be null!");

        character.getProperties().setHealthPoints(damage);
    }

}