package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.effects.HealEffect;
import com.roleplay.effects.InvisibleEffect;
import com.roleplay.items.Item;
import com.roleplay.items.ItemProperties;
import com.roleplay.items.armors.ChainArmor;
import com.roleplay.items.armors.IronArmor;
import com.roleplay.items.armors.LeatherArmor;
import com.roleplay.items.armors.Shield;
import com.roleplay.items.artefacts.*;
import com.roleplay.items.weapons.*;
import com.roleplay.map.GameMap;
import com.roleplay.map.GameMapCreator;
import com.roleplay.map.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardPanel extends JPanel implements ActionListener {
    private final GameMap gameMap;
    private final List<Item> items;
    public InventoryPanel inventoryPanel;
    FightPanel fightPanel = new FightPanel();

    public BoardPanel(Settings settings) {
        setLayout(new OverlayLayout(this));

        inventoryPanel = new InventoryPanel(settings);
        gameMap = GameMapCreator.loadRandomMap();
        gameMap.setSettings(settings);

        setPreferredSize(new Dimension(GameMap.TILE_SIZE * gameMap.getWidth(), GameMap.TILE_SIZE * gameMap.getHeight()));

        items = populateItems();

        Timer timer = new Timer(25, this);
        timer.start();

        add(inventoryPanel);
        add(fightPanel);

    }

    private List<Item> populateItems() {
        List<Item> itemList = new ArrayList<>();
        Random rand = new Random();
        Point position;
        int artefactX;
        int artefactY;

        for (int i = 0; i < rand.nextInt((gameMap.getWidth() * gameMap.getHeight()) / 4 * gameMap.getSettings().getPlayers().size()); i++) {
            do {
                artefactX = rand.nextInt(gameMap.getWidth());
                artefactY = rand.nextInt(gameMap.getHeight());

                position = new Point(artefactX, artefactY);
            } while (!gameMap.getMapElements()[artefactY][artefactX].getProperties().getName().equalsIgnoreCase("way"));

            Item item = switch (rand.nextInt(15)) {
                case 0 -> new Amulet(new ItemProperties(new Point(position)), new HealEffect(3));
                case 1 -> new Cape(new ItemProperties(new Point(position)), new InvisibleEffect(3));
                case 2 -> new Potion(new ItemProperties(new Point(position)), new HealEffect(3));
                case 3 -> new Ring(new ItemProperties(new Point(position)), new HealEffect(3));
                case 4 -> new LeatherArmor(new ItemProperties(new Point(position)));
                case 5 -> new ChainArmor(new ItemProperties(new Point(position)));
                case 6 -> new IronArmor(new ItemProperties(new Point(position)));
                case 7 -> new Shield(new ItemProperties(new Point(position)));
                case 8 -> new Dagger(new ItemProperties(new Point(position)));
                case 9 -> new Dart(new ItemProperties(new Point(position)));
                case 10 -> new HandAxe(new ItemProperties(new Point(position)));
                case 11 -> new Axe(new ItemProperties(new Point(position)));
                case 12 -> new Spear(new ItemProperties(new Point(position)));
                case 13 -> new Sword(new ItemProperties(new Point(position)));
                case 14 -> new Bow(new ItemProperties(new Point(position)));
                default -> null;
            };

            itemList.add(item);
        }

        return itemList;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(gameMap.getMap(), 0, 0, null);

        for (Item item : items) {
            item.draw(g, this);
        }
        for (Character character : gameMap.getSettings().getPlayers()) {
            character.draw(g, this);
        }

        Toolkit.getDefaultToolkit().sync();

    }

    public GameMap getGameMap() {
        return this.gameMap;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void update() {
        isCharachterOnPosition();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Character c : gameMap.getSettings().getPlayers()) {
            c.tick(gameMap.getWidth(), gameMap.getHeight());
        }

        repaint();
    }

    private void isCharachterOnPosition() {
        for (Character fighter : gameMap.getSettings().getPlayers()) {
            if (fighter.getProperties().isMyTurn()) {
                for (Character opponent : gameMap.getSettings().getPlayers()) {
                    if (!opponent.getProperties().isMyTurn() && fighter.getProperties().getPosition().equals(opponent.getProperties().getPosition())) {
                        setFightVisible(fighter, opponent);
                    }
                }
            }
        }
    }

    public void setInventoryVisible() {
        if (inventoryPanel.isVisible()) {
            inventoryPanel.setVisible(false);
        } else {
            inventoryPanel.setVisible(true);
            inventoryPanel.initialize();
        }
    }

    public void setFightVisible(Character fighter, Character opponent) {
        if (fightPanel.isVisible()) {
            fightPanel.setVisible(false);
        } else {
            fightPanel.setVisible(true);
            fightPanel.initialize(fighter, opponent);
        }
    }

}
