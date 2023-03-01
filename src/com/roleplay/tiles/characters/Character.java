package com.roleplay.tiles.characters;

import com.roleplay.effects.Effect;
import com.roleplay.gui.GameBoard;
import com.roleplay.tiles.Tile;
import com.roleplay.tiles.build.MapCreator;
import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.items.armors.Armor;
import com.roleplay.tiles.items.artefacts.Artefact;
import com.roleplay.tiles.items.weapons.Weapon;
import com.roleplay.tiles.properties.CharacterProperties;
import com.roleplay.tiles.properties.MapElementProperties;

import java.awt.*;
import java.awt.event.KeyEvent;
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

    public abstract void levelUp();

    protected void use(Item item) {

        if (item instanceof Armor) {
            ((CharacterProperties) getProperties()).getInventory().setArmor((Armor) item);
            //TODO
        } else if (item instanceof Weapon) {
            ((CharacterProperties) getProperties()).getInventory().setFirstHand((Weapon) item);
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
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            if(getProperties().getPosition().getY() > 0) {
                if(!((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y-1][getProperties().getPosition().x].getProperties()).getHitbox().isEnabled() && ((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y-1][getProperties().getPosition().x].getProperties()).getHitbox().getPosition() != ((CharacterProperties) getProperties()).getHitbox().getPosition()){
                    getProperties().getPosition().translate(0, -1);
                }
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
            if(getProperties().getPosition().getX() < 25) {
                if(!((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y][getProperties().getPosition().x + 1].getProperties()).getHitbox().isEnabled() && ((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y][getProperties().getPosition().x + 1].getProperties()).getHitbox().getPosition() != ((CharacterProperties) getProperties()).getHitbox().getPosition()){
                    getProperties().getPosition().translate(1, 0);
                }
            }
        }
        if (key == KeyEvent.VK_DOWN) {
            if (getProperties().getPosition().getY() < 40) {
                if (!((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y + 1][getProperties().getPosition().x].getProperties()).getHitbox().isEnabled() && ((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y+1][getProperties().getPosition().x].getProperties()).getHitbox().getPosition() != ((CharacterProperties) getProperties()).getHitbox().getPosition()){
                    getProperties().getPosition().translate(0, 1);
                }
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            if (getProperties().getPosition().getX() > 0) {
                if (!((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y][getProperties().getPosition().x - 1].getProperties()).getHitbox().isEnabled() && ((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y][getProperties().getPosition().x - 1].getProperties()).getHitbox().getPosition() != ((CharacterProperties) getProperties()).getHitbox().getPosition()){
                    getProperties().getPosition().translate(-1, 0);
                }
            }
        }
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
}
