package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.gui.GameBoard;
import com.roleplay.tiles.items.Item;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public abstract class Artefact extends Item {
    private final Effect effect;

    protected Artefact(String name, Effect effect, double weight, int id, Point pos) {
        super(name, weight, id, pos);
        this.effect = effect;
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                img,
                pos.x * GameBoard.tileSize,
                pos.y * GameBoard.tileSize,
                observer
        );
    }

    public Effect getEffect() {
        return effect;
    }

    public abstract void use(Character character);
}