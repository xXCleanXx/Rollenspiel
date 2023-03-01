package com.roleplay.effects;

import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;

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
        ((CharacterProperties)character.getProperties()).setHealthPoints(damage);
    }
}