package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;

public class Potion extends Artefact {
    public Potion(Effect effect) {
        super("potion", effect, 0);
        setImg(loadImage("src/com/roleplay/resources/images/potion.png"));
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