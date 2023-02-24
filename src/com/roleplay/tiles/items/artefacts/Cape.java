package com.roleplay.tiles.items.artefacts;

import com.roleplay.effects.Effect;
import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.items.Item;
import com.roleplay.tools.Image;

public class Cape extends Artefact {
    public Cape(Effect effect) {
        super("cape", effect, 0);
        setImg(Image.loadImage("src/com/roleplay/resources/images/items/cape.png"));
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