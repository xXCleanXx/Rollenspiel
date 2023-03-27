package com.roleplay.effects;

import com.roleplay.characters.Character;

import java.util.Timer;
import java.util.TimerTask;

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
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                character.getProperties().setVisible(true);
            }
        }, (long)getRuntime() * 1000);
    }
}