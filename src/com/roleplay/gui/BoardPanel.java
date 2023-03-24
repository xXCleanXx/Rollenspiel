package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.effects.HealEffect;
import com.roleplay.effects.InvisibleEffect;
import com.roleplay.items.ItemProperties;
import com.roleplay.items.artefacts.*;
import com.roleplay.map.GameMap;
import com.roleplay.map.GameMapCreator;
import com.roleplay.tools.ImageUtils;
import com.roleplay.interfaces.IObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BoardPanel extends JPanel implements ActionListener {
    private final GameMap gameMap;
    private final List<Artefact> artefacts;
    private final List<Character> players;

    InventoryPanel inventoryPanel = new InventoryPanel();

    FightPanel fightPanel = new FightPanel();

    public BoardPanel(ArrayList<Character> players) {
        setLayout(new OverlayLayout(this));

        this.players = players;
        gameMap = GameMapCreator.loadRandomMap();
        setPreferredSize(new Dimension(GameMap.TILE_SIZE * gameMap.getWidth(), GameMap.TILE_SIZE * gameMap.getHeight()));

        artefacts = populateArtefacts();

        Timer timer = new Timer(25, this);
        timer.start();

        add(inventoryPanel);
        add(fightPanel);

    }

    private List<Artefact> populateArtefacts() {
        List<Artefact> artefactList = new ArrayList<>();
        Random rand = new Random();
        Point position;
        int artefactX;
        int artefactY;

        for (int i = 0; i < rand.nextInt((gameMap.getWidth() * gameMap.getHeight()) / 4 * players.size()); i++) {
            do {
                artefactX = rand.nextInt(gameMap.getWidth());
                artefactY = rand.nextInt(gameMap.getHeight());

                position = new Point(artefactX, artefactY);
            } while (!gameMap.getMapElements()[artefactY][artefactX].getProperties().getName().equalsIgnoreCase("way"));

            Artefact item = switch (rand.nextInt(4)) {
                case 0 ->
                        new Amulet(new ItemProperties("amulet", new Point(position), ImageUtils.loadImage("src/com/roleplay/resources/images/items/amulet_32x32.png")), new HealEffect(3));
                case 1 ->
                        new Cape(new ItemProperties("cape", new Point(position), ImageUtils.loadImage("src/com/roleplay/resources/images/items/cape_32x32.png")), new InvisibleEffect(3));
                case 2 ->
                        new Potion(new ItemProperties("potion", new Point(position), ImageUtils.loadImage("src/com/roleplay/resources/images/items/potion_32x32.png")), new HealEffect(3));
                case 3 ->
                        new Ring(new ItemProperties("ring", new Point(position), ImageUtils.loadImage("src/com/roleplay/resources/images/items/ring_32x32.png")), new HealEffect(3));
                default -> null;
            };

            artefactList.add(item);
        }

        return artefactList;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(gameMap.getMap(), 0, 0, null);

        for (Artefact artefact : artefacts) {
            artefact.draw(g, this);
        }
        for (Character character : players) {
            character.draw(g, this);
        }

        Toolkit.getDefaultToolkit().sync();

    }

    public GameMap getGameMap() {
        return this.gameMap;
    }

    public List<Artefact> getArtefacts() {
        return this.artefacts;
    }

    public void update() {
        isCharachterOnPosition();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Character c : players) {
            c.tick(gameMap.getWidth(), gameMap.getHeight());
        }
        repaint();
    }

    private void isCharachterOnPosition() {
        for (Character fighter : MainFrame.getCharacterList()) {
            if (fighter.getProperties().isMyTurn()) {
                for (Character opponent : MainFrame.getCharacterList()) {
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
