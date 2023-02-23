package com.roleplay.tiles.characters;

public class Warrior extends Character {
    protected Warrior(CharacterBuilder characterBuilder) {
        super(characterBuilder);
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
