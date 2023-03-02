package com.roleplay.tiles.characters;

import com.roleplay.effects.Effect;
import com.roleplay.gui.GameBoard;
import com.roleplay.tiles.Entity;
import com.roleplay.tiles.build.MapCreator;
import com.roleplay.tiles.characters.enums.Directions;
import com.roleplay.tiles.characters.enums.Races;
import com.roleplay.tiles.items.Inventory;
import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.items.armors.Armor;
import com.roleplay.tiles.items.artefacts.Artefact;
import com.roleplay.tiles.items.weapons.Weapon;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class Character extends Entity {
    private Races race;
    private String displayName;
    private double maxHealthPoints, healthPoints;
    private boolean visible = true;
    public BufferedImage img;
    private Directions direction = Directions.NORTH;
    private Abilities abilities;
    private Inventory inventory;
    private final List<Effect> effects = new ArrayList<>();

    protected Character(CharacterBuilder builder) {
        super(builder.getName());

        super.setDisplayName(builder.getDisplayName());
        setAbilities(builder.getAbilities());
        setInventory(builder.getInventory());
        setHealthPoints(builder.getHealthPoints());
        setMaxHealthPoints(builder.getMaxHealthPoints());
        setRace(builder.getRace());
    }

    public Races getRace() {
        return this.race;
    }

    private void setRace(Races race) {
        this.race = race;
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

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        if (direction == null) throw new IllegalArgumentException("Direction cannot be null!");

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

    public abstract double attack(Character enemy);

    public abstract double defend();

    public abstract void levelUp();

    protected void use(Item item) {

        if (item instanceof Armor) {
            inventory.setArmor((Armor) item);
            //TODO
        } else if (item instanceof Weapon) {
            inventory.setFirstHand((Weapon) item);
            //TODO
        } else if (item instanceof Artefact) {

        }
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                img,
                getPosition().x * GameBoard.tileSize,
                getPosition().y * GameBoard.tileSize,
                observer
        );
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            if(getPosition().getY() > 0) {
                if(MapCreator.getMap()[getPosition().y-1][getPosition().x].collusionDetected(MapCreator.getMap()[getPosition().y-1][getPosition().x].getHitBox(), getHitBox())){
                    getPosition().translate(0, -1);
                }
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
            if(getPosition().getX() < 25) {
                if (MapCreator.getMap()[getPosition().y][getPosition().x + 1].collusionDetected(MapCreator.getMap()[getPosition().y][getPosition().x + 1].getHitBox(), getHitBox())) {
                    getPosition().translate(1, 0);
                }
            }
        }
        if (key == KeyEvent.VK_DOWN) {
            if (getPosition().getY() < 40) {
                if (MapCreator.getMap()[getPosition().y + 1][getPosition().x].collusionDetected(MapCreator.getMap()[getPosition().y + 1][getPosition().x].getHitBox(), getHitBox())){
                    getPosition().translate(0, 1);
                }
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            if (getPosition().getX() > 0) {
                if (MapCreator.getMap()[getPosition().y][getPosition().x - 1].collusionDetected(MapCreator.getMap()[getPosition().y][getPosition().x - 1].getHitBox(), getHitBox())){
                    getPosition().translate(-1, 0);
                }
            }
        }
    }

    //prevents player from disappear
    public void tick(int columns, int rows) {
        if (getPosition().x < 0) {
            getPosition().x = 0;
        } else if (getPosition().x >= columns) {
            getPosition().x = columns - 1;
        }
        if (getPosition().y < 0) {
            getPosition().y = 0;
        } else if (getPosition().y >= rows) {
            getPosition().y = rows - 1;
        }
    }
}
