package com.roleplay.characters;

import com.roleplay.characters.enums.Directions;

import java.awt.geom.Point2D;

public abstract class Character {

    private String name;
    private double healthPoints;
    private Point2D position;
    private Directions direction;
    private Abilities abilities;
    private Weapon currentWeapon;
    private Armor amor;
    private Inventory inventory;

    public abstract double attack(Character enemy);

    public abstract double defend();

    public abstract void levelUp();

    public void use(){
        //toDo
    }
}
