package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;

import java.awt.*;

public class Ring extends Artefact {
    public Ring(String name, Effect effect, Point pos) {
        super(name, effect, 0, pos);
        setImg(loadImage("src/com/roleplay/resources/images/ring.png"));
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        return new Ring(getName(), getEffect(), getPosition());
    }
}
