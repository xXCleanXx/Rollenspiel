package com.roleplay.tiles.properties;

import com.roleplay.tiles.Hitbox;
import com.roleplay.tiles.characters.Abilities;
import com.roleplay.tiles.characters.enums.Directions;
import com.roleplay.tiles.items.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CharacterProperties extends TileProperties{


    private boolean visible = true;
    private Directions direction = Directions.NORTH;
    private String displayName;
    private Abilities abilities;
    private Inventory inventory;
    private final Hitbox hitbox;
    private double maxHealthPoints, healthPoints;


    public CharacterProperties(String name, Point position, BufferedImage texture) {
        super(name, position, texture);

        hitbox = new Hitbox(position, 32,32);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        if (direction == null) throw new IllegalArgumentException("Direction cannot be null!");

        this.direction = direction;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;

    }

    public double getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(double maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;

    }

}
