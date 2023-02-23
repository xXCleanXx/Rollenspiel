package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;

import java.awt.*;

public class Potion extends Artefact {
    public Potion(String name, Effect effect, Point pos) {
        super(name, effect, 0, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        return new Potion(getName(), getEffect(), getPos());
    }
}