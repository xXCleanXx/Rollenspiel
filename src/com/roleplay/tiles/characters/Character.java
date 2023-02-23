package com.roleplay.tiles.characters;

import com.roleplay.gui.GameBoard;
import com.roleplay.tiles.characters.enums.Directions;
import com.roleplay.effects.Effect;
import com.roleplay.tiles.items.Inventory;
import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.items.armors.Armor;
import com.roleplay.tiles.items.artefacts.Artefact;
import com.roleplay.tiles.items.weapons.Weapon;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private String name, displayName;
    private double maxHealthPoints, healthPoints;
    private boolean visible = true;
    private Point pos;
    public BufferedImage img;
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

    public Point getPosition() {
        return pos;
    }

    public void setPosition(Point position) {
        this.pos = position;
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
    public void setImg(BufferedImage img){
        this.img = img;
    }

    public void draw(Graphics g, ImageObserver observer) {
        // with the Point class, note that pos.getX() returns a double, but
        // pos.x reliably returns an int. https://stackoverflow.com/a/30220114/4655368
        // this is also where we translate board grid position into a canvas pixel
        // position by multiplying by the tile size.
        g.drawImage(
                img,
                pos.x * GameBoard.tileSize,
                pos.y * GameBoard.tileSize,
                observer
        );
    }

}