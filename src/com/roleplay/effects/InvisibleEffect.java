package com.roleplay.effects;

import com.roleplay.characters.Character;

public class InvisibleEffect extends Effect {
    private double runtime;

    public InvisibleEffect(double runtime) {
        setRuntime(runtime);
    }

    private void setRuntime(double runtime) {
        if (runtime < 0) {
            throw new IllegalArgumentException("Runtime cannot be less than 0!");
        }

        this.runtime = runtime;
    }

    @Override
    public void apply(Character character) {
        character.setVisible(false);
    }
}