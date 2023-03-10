package com.roleplay.effects;

import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;

public class InvisibleEffect extends Effect {
    private double runtime;

    public InvisibleEffect(double runtime) {
        setRuntime(runtime);
    }

    public double getRuntime() {
        return runtime;
    }

    private void setRuntime(double runtime) {
        if (runtime < 0) throw new IllegalArgumentException("Runtime cannot be less than 0!");

        this.runtime = runtime;
    }

    @Override
    public void apply(Character character) {
        if (character == null) throw new IllegalArgumentException("Character cannot be null!");

        character.getProperties().setVisible(false);
    }
}