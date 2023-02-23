package com.roleplay.tiles;

import com.roleplay.gui.GameBoard;
import com.roleplay.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class TileCreator{

    public ArrayList<Tile> tiles = new ArrayList<>();

    public void createTiles(BufferedImage img , int rows, int columns, int tileSize) {

        Tile[][] map = new Tile[rows][columns];
        try{
            BufferedReader bR;
            Random random = new Random();
            switch (random.nextInt(3)){
                case 0: bR = new BufferedReader(new FileReader("src/com/roleplay/resources/maps/map.txt")); break;
                case 1: bR = new BufferedReader(new FileReader("src/com/roleplay/resources/maps/map1.txt")); break;
                case 2: bR = new BufferedReader(new FileReader("src/com/roleplay/resources/maps/map2.txt")); break;
                default: bR = null;
            }

            for(int i = 0; i < rows; i++){
                String text = bR.readLine();
                for(int j = 0; j < columns; j++){
                    switch (java.lang.Character.getNumericValue(text.charAt(j))){
                        case 0: map[i][j] = new Tile("background", new Point(i,j),ImageIO.read(new File("src/com/roleplay/resources/images/background.png")));break;
                        case 1: map[i][j] = new Tile("way", new Point(i,j),ImageIO.read(new File("src/com/roleplay/resources/images/way.png")));break;
                        case 2: map[i][j] = new Tile("water", new Point(i,j),ImageIO.read(new File("src/com/roleplay/resources/images/water.png")));break;
                    }
                    tiles.add(map[i][j]);
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                final BufferedImage tile = map[j][i].getImg();
                for (int x = 0; x < tile.getWidth(); x++) {
                    for (int y = 0; y < tile.getHeight(); y++) {
                        img.setRGB( x + i * tileSize, y + j * tileSize, tile.getRGB(x,y) );
                    }
                }
            }
        }
    }
}