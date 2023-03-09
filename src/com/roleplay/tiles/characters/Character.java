package com.roleplay.tiles.characters;

import com.roleplay.effects.Effect;
import com.roleplay.gui.GameBoard;
import com.roleplay.tiles.Tile;
import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.items.armors.Armor;
import com.roleplay.tiles.items.artefacts.Artefact;
import com.roleplay.tiles.items.weapons.Weapon;
import com.roleplay.tiles.properties.CharacterProperties;
import com.roleplay.tiles.properties.TileProperties;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class Character extends Tile {
    private final List<Effect> effects = new ArrayList<>();

    protected Character(CharacterProperties characterProperties) {
        super(characterProperties);
    }

    public abstract double attack(Character enemy);

    public abstract double defend();

    public void levelUp() {
        getProperties().setXp(0);
        getProperties().setLevel(getProperties().getLevel());
    }

    protected void use(Item item) {

        if (item instanceof Armor) {
            getProperties().getInventory().setArmor((Armor) item);
            //TODO
        } else if (item instanceof Weapon) {
            getProperties().getInventory().setFirstHand(item);
            //TODO
        } else if (item instanceof Artefact) {

        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                getProperties().getTexture(),
                getProperties().getPosition().x * GameBoard.tileSize,
                getProperties().getPosition().y * GameBoard.tileSize,
                observer
        );
    }

    //prevents player from disappear
    public void tick(int columns, int rows) {
        if (getProperties().getPosition().x < 0) {
            getProperties().getPosition().x = 0;
        } else if (getProperties().getPosition().x >= columns) {
            getProperties().getPosition().x = columns - 1;
        }
        if (getProperties().getPosition().y < 0) {
            getProperties().getPosition().y = 0;
        } else if (getProperties().getPosition().y >= rows) {
            getProperties().getPosition().y = rows - 1;
        }
    }
    @Override
    public CharacterProperties getProperties(){
        return (CharacterProperties) super.getProperties();
    }
}
