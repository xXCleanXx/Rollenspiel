package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tiles.properties.TileProperties;
import com.roleplay.tools.Image;

public class Amulet extends Artefact {

    public Amulet(ItemProperties itemProperties, Effect effect) {
        super(itemProperties, effect);
    }
    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        Amulet amulet = new Amulet((ItemProperties) getProperties(), getEffect());
        amulet.getProperties().setPosition(getProperties().getPosition());
        ((ItemProperties) amulet.getProperties()).setDisplayName(((ItemProperties)getProperties()).getDisplayName());

        return amulet;
    }
}
