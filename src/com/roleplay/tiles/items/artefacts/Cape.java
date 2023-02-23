package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;

public class Cape extends Artefact {
    public Cape(Effect effect) {
        super("cape", effect, 0);
        setImg(loadImage("src/com/roleplay/resources/images/cape.png"));
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        Cape cape = new Cape(getEffect());
        cape.setPosition(getPosition());
        cape.setDisplayName(getDisplayName());

        return cape;
    }
}