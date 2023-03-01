package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

public class Cape extends Artefact {
    public Cape(ItemProperties itemProperties , Effect effect) {
        super(itemProperties, effect);
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        Cape cape = new Cape((ItemProperties) getProperties(), getEffect());
        cape.getProperties().setPosition(getProperties().getPosition());
        ((ItemProperties) cape.getProperties()).setDisplayName(((ItemProperties)getProperties()).getDisplayName());

        return cape;
    }
}