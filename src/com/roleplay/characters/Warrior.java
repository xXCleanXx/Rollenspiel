package com.roleplay.characters;

public class Warrior extends Character {
    protected Warrior(String name, double healthPoints) {
        super(name, healthPoints);
    }

    @Override
    public double attack(Character enemy) {
        return 0;
    }

    @Override
    public double defend() {
        return 0;
    }

    @Override
    public void levelUp() {

    }
}
