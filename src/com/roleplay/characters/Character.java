package com.roleplay.characters;

import com.roleplay.characters.enums.Directions;
import com.roleplay.items.Item;
import com.roleplay.items.armors.Armor;
import com.roleplay.items.armors.Shield;
import com.roleplay.map.GameMap;
import com.roleplay.map.Tile;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class Character extends Tile<CharacterProperties> {
    protected Character(CharacterProperties characterProperties) {
        super(characterProperties);
    }

    public double defend() {
        Armor armor = this.getProperties().getInventory().getArmor();
        double armorDefence = armor == null ? 0 : armor.getStrength();
        double shieldDefence = this.getProperties().getInventory().getSecondHand() instanceof Shield shield ? shield.getStrength() : 0;

        return armorDefence + shieldDefence;
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                getProperties().getTexture32(),
                getProperties().getPosition().x * GameMap.TILE_SIZE,
                getProperties().getPosition().y * GameMap.TILE_SIZE,
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

    public void collectItem(Item item) {
        this.getProperties().getInventory().add(item);
    }

    public void changeDirection(Directions e) {
        getProperties().setDirection(e);
    }
}
