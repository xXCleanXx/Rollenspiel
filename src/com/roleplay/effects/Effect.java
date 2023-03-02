package com.roleplay.effects;

import com.roleplay.tiles.characters.Character;

public abstract class Effect {
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public abstract void apply(Character character);
}