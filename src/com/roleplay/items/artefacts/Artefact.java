package com.roleplay.items.artefacts;

import com.roleplay.effects.Effect;
import com.roleplay.characters.Character;
import com.roleplay.items.Item;
import com.roleplay.items.ItemProperties;
import com.roleplay.map.GameMap;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class Artefact extends Item {
    private Effect effect;

    protected Artefact(ItemProperties itemProperties ,Effect effect) {
        super(itemProperties);
         getProperties().setWeight(0);

        setEffect(effect);
    }

    public Effect getEffect() {
        return effect;
    }

    private void setEffect(Effect effect) {
        if (effect == null) throw new IllegalArgumentException("Effect cannot be null!");

        this.effect = effect;
    }

    public abstract void use(Character character);
}
