package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class Amulet extends Artefact {

    public Amulet(Effect effect) {
        super("amulet", effect, 0);

        loadTexture("src/com/roleplay/resources/images/items/amulet.png");
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
