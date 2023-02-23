package com.roleplay.gui;

;
import com.roleplay.tiles.Tile;
import com.roleplay.tiles.TileCreator;
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
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


public class GameBoard extends JPanel implements ActionListener {

    public static final int tileSize = 32;
    private final int columns = 50;
    private final int rows = 30;

    private BufferedImage img;

    private ArrayList<Artefact> artefacts;

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
        players.add(new Thief(characterBuilder,new Point(0,0)));

        img = new BufferedImage(tileSize * columns, tileSize * rows, BufferedImage.TYPE_INT_ARGB);   // here you should create a compatible BufferedImage
        TileCreator tC = new TileCreator();
        tC.createTiles(img , rows, columns, tileSize);
        map = tC.getMap();

        artefacts = populateArtefacts();



        Timer timer = new Timer(25, this);
        timer.start();

    }

    private ArrayList populateArtefacts() {
        ArrayList artefactList = new ArrayList<>();
        Random rand = new Random();

        // create the given number of coins in random positions on the board.
        // note that there is not check here to prevent two coins from occupying the same
        // spot, nor to prevent coins from spawning in the same spot as the player
        for (int i = 0; i < rand.nextInt((columns*rows)/4); i++) {
            int artefactX = rand.nextInt(columns);
            int artefactY = rand.nextInt(rows);

            Point position = new Point(artefactX,artefactY);
            while (!map[artefactY][artefactX].getName().equalsIgnoreCase("way")){
                artefactX = rand.nextInt(columns);
                artefactY = rand.nextInt(rows);

                position = new Point(artefactX,artefactY);
            }



            switch (rand.nextInt(4)) {
                case 0 -> artefactList.add(new Amulet("Amulet", null, position));
                case 1 -> artefactList.add(new Cape("Cape", null, position));
                case 2 -> artefactList.add(new Potion("Potion", null, position));
                case 3 -> artefactList.add(new Ring("Ring", null, position));
            }


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

        for(Character character : players){
            character.draw(g, this);
        }

        Toolkit.getDefaultToolkit().sync();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
