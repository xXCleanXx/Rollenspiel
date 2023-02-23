package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;

import java.awt.*;

public class Ring extends Artefact {
    public Ring(Effect effect) {
        super("ring", effect, 0);
        setImg(loadImage("src/com/roleplay/resources/images/ring.png"));
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        Ring ring = new Ring(getEffect());
        ring.setPosition(getPosition());
        ring.setDisplayName(getDisplayName());

        return ring;
    }
}
