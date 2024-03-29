package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class Potion extends Artefact {
    public Potion(Effect effect) {
        super("potion", effect, 0);
        loadTexture("src/com/roleplay/resources/images/items/potion.png");
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        return new Potion(getEffect());
    }
}