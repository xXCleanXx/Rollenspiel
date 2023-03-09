package com.roleplay.tiles.items.artefacts;

import com.roleplay.effects.Effect;
import com.roleplay.gui.GameBoard;
import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;

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
                getProperties().getTexture(),
                getProperties().getPosition().x * GameBoard.tileSize,
                getProperties().getPosition().y * GameBoard.tileSize,
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
