package com.roleplay.tiles.characters;

import com.roleplay.effects.Effect;
import com.roleplay.gui.GameBoard;
import com.roleplay.tiles.Tile;
import com.roleplay.tiles.build.MapCreator;
import com.roleplay.tiles.characters.enums.Directions;
import com.roleplay.tiles.characters.enums.Races;
import com.roleplay.tiles.items.Inventory;
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
    private Inventory inventory;

    protected Character(CharacterProperties characterProperties) {
        super(characterProperties);
    }

    public abstract double attack(Character enemy);

    public abstract double defend();

    public abstract void levelUp();

    protected void use(Item item) {

        if (item instanceof Armor) {
            getInventory().setArmor((Armor) item);
            //TODO
        } else if (item instanceof Weapon) {
            getInventory().setFirstHand((Weapon) item);
            //TODO
        } else if (item instanceof Artefact) {

        }
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
                if(!((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y-1][getProperties().getPosition().x].getProperties()).getHitbox().isEnabled() && MapCreator.getMap()[getProperties().getPosition().y-1][getProperties().getPosition().x].getProperties().getPosition() != getProperties().getPosition()){
                    getProperties().getPosition().translate(0, -1);
                }
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
            if(getProperties().getPosition().getX() < 40) {
                if(!((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y][getProperties().getPosition().x + 1].getProperties()).getHitbox().isEnabled() &&  MapCreator.getMap()[getProperties().getPosition().y][getProperties().getPosition().x + 1].getProperties().getPosition() != getProperties().getPosition()){
                    getProperties().getPosition().translate(1, 0);
                }
            }
        }
        if (key == KeyEvent.VK_DOWN) {
            if (getProperties().getPosition().getY() < 25) {
                if (!((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y + 1][getProperties().getPosition().x].getProperties()).getHitbox().isEnabled() && MapCreator.getMap()[getProperties().getPosition().y+1][getProperties().getPosition().x].getProperties().getPosition() != getProperties().getPosition()){
                    getProperties().getPosition().translate(0, 1);
                }
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            if (getProperties().getPosition().getX() > 0) {
                if (!((MapElementProperties) MapCreator.getMap()[getProperties().getPosition().y][getProperties().getPosition().x - 1].getProperties()).getHitbox().isEnabled() && MapCreator.getMap()[getProperties().getPosition().y][getProperties().getPosition().x - 1].getProperties().getPosition() != getProperties().getPosition()){
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;

    }
}
