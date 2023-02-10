package com.roleplay.characters;

import com.roleplay.characters.enums.Directions;
import com.roleplay.items.Inventory;
import com.roleplay.items.Item;
import com.roleplay.items.armors.Armor;
import com.roleplay.items.artefacts.Artefact;
import com.roleplay.items.weapons.Weapon;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Character {

    private String name;
    private double healthPoints;
    private Point2D position;
    private Directions direction;
    private Abilities abilities;
    private Inventory inventory;

    protected Character(String name, double healthPoints) {
        setName(name);
        setHealthPoints(healthPoints);
        setPosition(new Point(0,0));
        setDirection(Directions.NORTH);
    }

    public abstract double attack(Character enemy);

    public abstract double defend();

    public abstract void levelUp();

    protected void use(Item item){
        if(item instanceof Armor) {
            inventory.setArmor((Armor)item);
            //TODO
        } else if (item instanceof Weapon){
            inventory.setCurrentWeapon((Weapon)item);
            //TODO
        } else{
            inventory.useArtefact((Artefact) item);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
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

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
