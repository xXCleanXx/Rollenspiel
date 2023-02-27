package com.roleplay.tiles.characters;

import com.roleplay.tiles.items.Inventory;

public class CharacterBuilder {
    private String name, displayName;
    private Abilities abilities;
    private Inventory inventory;
    private double maxHealthPoints, healthPoints;


    public CharacterBuilder() {
        setInventory(new Inventory(30));
        setAbilities(new Abilities());
    }

    public String getName() {
        return name;
    }

    public CharacterBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public CharacterBuilder setDisplayName(String displayName) {
        this.displayName = displayName;

        return this;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public CharacterBuilder setAbilities(Abilities abilities) {
        this.abilities = abilities;

        return this;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public CharacterBuilder setInventory(Inventory inventory) {
        this.inventory = inventory;

        return this;
    }

    public double getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public CharacterBuilder setMaxHealthPoints(double maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;

        return this;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public CharacterBuilder setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;

        return this;
    }
}