package com.roleplay.characters;

import com.roleplay.characters.enums.Directions;
import com.roleplay.effects.Effect;
import com.roleplay.items.Inventory;
import com.roleplay.items.Item;
import com.roleplay.items.armors.Armor;
import com.roleplay.items.artefacts.Artefact;
import com.roleplay.items.weapons.Weapon;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private String name, displayName;
    private double maxHealthPoints, healthPoints;
    private boolean visible = true;
    private Point2D position = new Point();
    private Directions direction = Directions.NORTH;
    private Abilities abilities;
    private Inventory inventory;
    private final List<Effect> effects = new ArrayList<>();

    protected Character(CharacterBuilder builder) {
        setName(builder.getName());
        setDisplayName(builder.getDisplayName());
        setAbilities(builder.getAbilities());
        setInventory(builder.getInventory());
        setHealthPoints(builder.getHealthPoints());
        setMaxHealthPoints(builder.getMaxHealthPoints());
    }

    public abstract double attack(Character enemy);

    public abstract double defend();

    public abstract void levelUp();

    protected void use(Item item) {
        if(item instanceof Armor) {
            inventory.setArmor((Armor)item);
            //TODO
        } else if (item instanceof Weapon){
            inventory.setCurrentWeapon((Weapon)item);
            //TODO
        } else if (item instanceof Artefact) {

        }
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null!");

        this.name = name;
    }

    public double getMaxHealthPoints() {
        return maxHealthPoints;
    }

    private void setMaxHealthPoints(double maxHealthPoints) {
        if (maxHealthPoints < 0) throw new IllegalArgumentException("Health points cannot be less than 0!");

        this.maxHealthPoints = maxHealthPoints;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        if (healthPoints > getMaxHealthPoints()) {
            this.healthPoints = getMaxHealthPoints();

            return;
        }

        this.healthPoints = healthPoints;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean flag) {
        visible = flag;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    private void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public Inventory getInventory() {
        return inventory;
    }

    private void setInventory(Inventory inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null!");
        }

        this.inventory = inventory;
    }
}
