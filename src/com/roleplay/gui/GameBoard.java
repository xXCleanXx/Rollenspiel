package com.roleplay.gui;

import com.roleplay.effects.HealEffect;
import com.roleplay.effects.InvisibleEffect;
import com.roleplay.tiles.Tile;
import com.roleplay.tiles.build.MapCreator;
import com.roleplay.tiles.characters.Abilities;
import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.characters.CharacterBuilder;
import com.roleplay.tiles.characters.Thief;
import com.roleplay.tiles.items.Inventory;
import com.roleplay.tiles.items.artefacts.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameBoard extends JPanel implements ActionListener, KeyListener {

    public static final int tileSize = 32;
    private final int columns = 40;
    private final int rows = 25;

    private BufferedImage img;

    private List<Artefact> artefacts;

    private ArrayList<Character> players;

    private Tile[][] map;

    public GameBoard() {
        setPreferredSize(new Dimension(tileSize * columns, tileSize * rows));

        players = new ArrayList<>();

        CharacterBuilder characterBuilder = new CharacterBuilder();
        characterBuilder.setAbilities(new Abilities());
        characterBuilder.setName("test");
        characterBuilder.setInventory(new Inventory(15));
        characterBuilder.setDisplayName("test2");
        characterBuilder.setHealthPoints(20);
        characterBuilder.setMaxHealthPoints(25);
        players.add(new Thief(characterBuilder, new Point(0, 0)));

        img = new BufferedImage(tileSize * columns, tileSize * rows, BufferedImage.TYPE_INT_ARGB);   // here you should create a compatible BufferedImage
        new MapCreator(img, rows, columns, tileSize);
        map = MapCreator.getMap();

        artefacts = populateArtefacts();


        Timer timer = new Timer(25, this);
        timer.start();

    }

    private List<Artefact> populateArtefacts() {
        List<Artefact> artefactList = new ArrayList<>();
        Random rand = new Random();
        Point position;
        int artefactX;
        int artefactY;

        for (int i = 0; i < rand.nextInt((columns * rows) / 4); i++) {
            do {
                artefactX = rand.nextInt(columns);
                artefactY = rand.nextInt(rows);

                position = new Point(artefactX, artefactY);
            } while (!map[artefactY][artefactX].getName().equalsIgnoreCase("way"));

            Artefact item = switch (rand.nextInt(4)) {
                case 0 -> new Amulet(new HealEffect(3));
                case 1 -> new Cape(new InvisibleEffect(3));
                case 2 -> new Potion(new HealEffect(3));
                case 3 -> new Ring(new HealEffect(3));
                default -> null;
            };

            item.setPosition(position);

            artefactList.add(item);
        }

        return artefactList;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img, 0, 0, null);

        for (Artefact artefact : artefacts) {
            artefact.draw(g, this);
        }
        for (Character character : players) {
            character.draw(g, this);
        }

        Toolkit.getDefaultToolkit().sync();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(Character c : players){
            c.tick(columns,rows);
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        for(Character player : players) {
            player.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // react to key up events
    }
}
