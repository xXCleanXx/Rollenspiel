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

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                getProperties().getTexture32(),
                getProperties().getPosition().x * GameMap.TILE_SIZE,
                getProperties().getPosition().y * GameMap.TILE_SIZE,
                observer
        );
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
