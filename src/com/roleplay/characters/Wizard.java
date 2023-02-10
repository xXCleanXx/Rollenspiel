package com.roleplay.characters;

public class Wizard extends Character {
    protected Wizard(CharacterBuilder characterBuilder) {
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
