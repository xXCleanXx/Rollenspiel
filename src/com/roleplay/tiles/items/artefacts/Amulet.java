package com.roleplay.tiles.items.artefacts;

import com.roleplay.tiles.characters.Character;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Item;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Amulet extends Artefact {

    public Amulet(String name, Effect effect, Point pos) {
        super(name, effect, 0, pos);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }
    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    @Override
    public Item clone() {
        return new Amulet(getName(), getEffect() , getPos());
    }
}
