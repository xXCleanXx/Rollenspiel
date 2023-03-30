package com.roleplay.gui;

import com.roleplay.Factories.ItemFactory;
import com.roleplay.characters.Character;
import com.roleplay.characters.CharacterProperties;
import com.roleplay.characters.Monster;
import com.roleplay.items.Item;
import com.roleplay.items.ItemProperties;
import com.roleplay.items.Key;
import com.roleplay.items.MortalInstruments;
import com.roleplay.map.GameMap;
import com.roleplay.map.GameMapCreator;
import com.roleplay.map.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BoardPanel extends JPanel implements ActionListener {
    private final GameMap gameMap;
    public InventoryPanel inventoryPanel;
    private final FightPanel fightPanel = new FightPanel();
    private static final EndInfoPanel endInfoPanel = new EndInfoPanel();

    public BoardPanel(Settings settings) {
        setLayout(new OverlayLayout(this));

        inventoryPanel = new InventoryPanel(settings);
        gameMap = GameMapCreator.loadRandomMap();
        gameMap.setSettings(settings);

        setPreferredSize(new Dimension(GameMap.TILE_SIZE * gameMap.getWidth(), GameMap.TILE_SIZE * gameMap.getHeight()));

        populateItems();
        populateMonsters();

        Timer timer = new Timer(25, this);
        timer.start();

        add(inventoryPanel);
        add(fightPanel);
        add(new StartInfoPanel());
        add(endInfoPanel);
    }

    private Point generatePoint(Random random) {
        Point position;

        do {
            position = new Point(random.nextInt(gameMap.getWidth()), random.nextInt(gameMap.getHeight()));
        } while (!gameMap.getMapElements()[position.y][position.x].getProperties().getName().equalsIgnoreCase("way"));

        return position;
    }

    private void populateMonsters() {
        Random rand = new Random();
        Point position;

        int count = switch (gameMap.getSettings().getDifficulty()) {
            case HARD -> gameMap.getSettings().getPlayerCount() * 4;
            case HARDCORE -> gameMap.getSettings().getPlayerCount() * 3;
            case MEDIUM -> gameMap.getSettings().getPlayerCount() * 2;
            case EASY -> gameMap.getSettings().getPlayerCount();
        };

        for (int i = 0; i < count; i++) {
            position = generatePoint(rand);
            gameMap.addMonster(new Monster(new CharacterProperties(new Point(position))));
        }
    }

    private void populateItems() {
        Random rand = new Random();
        Point position;

        for (int i = 0; i < rand.nextInt((gameMap.getWidth() * gameMap.getHeight()) / 4 * gameMap.getSettings().getPlayers().size()); i++) {
            position = generatePoint(rand);
            ItemFactory itemFactory = new ItemFactory(gameMap.getSettings());
            Item item = itemFactory.createItemByName(gameMap.getSettings().getItemWhiteList().get(rand.nextInt(getGameMap().getSettings().getItemWhiteList().size())).getProperties().getName());
            item.getProperties().setPosition(new Point(position));
            gameMap.addItem(item);
        }

        for (int i = 0; i < 5; i++) {
            position = generatePoint(rand);
            gameMap.addItem(new Key(new ItemProperties(new Point(position))));
        }

        for (int i = 1; i <= 3; i++) {
            position = generatePoint(rand);
            gameMap.addItem(new MortalInstruments(new ItemProperties(new Point(position)), i));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(gameMap.getMap(), 0, 0, null);

        for (Item item : gameMap.getItems()) {
            item.draw(g, this);
        }

        for (Character item : gameMap.getSettings().getPlayers()) {
            item.draw(g, this);
        }

        for (Monster monster : gameMap.getMonsters()) {
            monster.draw(g, this);
        }

        Toolkit.getDefaultToolkit().sync();

    }

    public GameMap getGameMap() {
        return this.gameMap;
    }

    public void update() {
        isCharacterOnPosition();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Character c : gameMap.getSettings().getPlayers()) {
            c.tick(gameMap.getWidth(), gameMap.getHeight());
        }

        repaint();
    }

    private void isCharacterOnPosition() {
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

    public static void setInfoVisible() {
        endInfoPanel.setVisible(true);
    }

}
