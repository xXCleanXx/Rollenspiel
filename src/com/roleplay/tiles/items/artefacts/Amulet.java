package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;

public class Amulet extends Artefact {

    public Amulet(Effect effect) {
        super("amulet", effect, 0);
        setImg(loadImage("src/com/roleplay/resources/images/amulet.png"));
    }
    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        Amulet amulet = new Amulet(getEffect());
        amulet.setPosition(getPosition());
        amulet.setDisplayName(getDisplayName());

        return amulet;
    }
}
