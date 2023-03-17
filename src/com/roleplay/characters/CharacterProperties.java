package com.roleplay.characters;

import com.roleplay.effects.Effect;
import com.roleplay.characters.enums.Directions;
import com.roleplay.characters.enums.Races;
import com.roleplay.items.Inventory;
import com.roleplay.map.MapElementProperties;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class CharacterProperties extends MapElementProperties {
    private final List<Effect> effects = new ArrayList<>();
    private Races race;
    private boolean visible = true;
    private Directions direction = Directions.NORTH;
    private String displayName;
    private Abilities abilities;
    private double healthPoints;
    private Inventory inventory;
    private int level;
    private int xp;
    private boolean myTurn = false;

    public CharacterProperties(Point position, BufferedImage texture) {
        super(position, texture);
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

    public Races getRace() {
        return race;
    }

    public void setRace(Races race){
        this.race = race;
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
    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void addXp(int xp) {
        this.xp += xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addEffect(Effect effect) {
        if (effect == null) throw new IllegalArgumentException("Effect cannot be null!");

        this.effects.add(effect);
    }

    public Effect[] getEffects() {
        return effects.toArray(new Effect[0]);
    }

    public boolean isMyTurn(){
        return this.myTurn;
    }

    public void setMyTurn(boolean myTurn){
        this.myTurn = myTurn;
    }
}