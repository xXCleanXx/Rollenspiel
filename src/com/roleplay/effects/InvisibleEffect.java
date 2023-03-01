package com.roleplay.effects;

import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;

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
        ((CharacterProperties) character.getProperties()).setVisible(false);
    }
}