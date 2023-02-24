package com.roleplay.tiles.items.artefacts;

import com.roleplay.effects.Effect;
import com.roleplay.gui.GameBoard;
import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.items.Item;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class Artefact extends Item {
    private Effect effect;

    protected Artefact(String name, Effect effect, double weight) {
        super(name, weight);

        setEffect(effect);
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                getImg(),
                getPosition().x * GameBoard.tileSize,
                getPosition().y * GameBoard.tileSize,
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
