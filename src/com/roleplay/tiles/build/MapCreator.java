package com.roleplay.tiles.build;

import com.roleplay.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class MapCreator {

    private static Tile[][] map;

    public MapCreator(BufferedImage img, int rows, int columns, int tileSize) {
        createTiles(img, rows, columns, tileSize);
    }

    private void createTiles(BufferedImage img, int rows, int columns, int tileSize) {

        map = new Tile[rows][columns];
        try {
            Random random = new Random();
            List<String> lines = switch (random.nextInt(1)) {
                case 0 -> Files.readAllLines(Paths.get("src/com/roleplay/resources/maps/map.txt"));
                case 1 -> Files.readAllLines(Paths.get("src/com/roleplay/resources/maps/map1.txt"));
                case 2 -> Files.readAllLines(Paths.get("src/com/roleplay/resources/maps/map2.txt"));
                default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(1));
            };


            for (int i = 0; i < rows; i++) {
                String text = lines.get(i);
                System.out.println(text);
                for (int j = 0; j < columns; j++) {
                    map[i][j] =  switch (Character.getNumericValue(text.charAt(j))) {
                        case 0 -> new Tile ("background", new Point(i, j), ImageIO.read(new File("src/com/roleplay/resources/images/background.png")));
                        case 1 -> new Tile("way", new Point(i, j), ImageIO.read(new File("src/com/roleplay/resources/images/way.png")), false);
                        case 2 -> new Tile("water", new Point(i, j), ImageIO.read(new File("src/com/roleplay/resources/images/water.png")));
                        case 3 -> new Door("door", new Point(i, j),ImageIO.read(new File("src/com/roleplay/resources/images/door.png")));
                        case 4 -> new Door("doorRotated", new Point(i, j), ImageIO.read(new File("src/com/roleplay/resources/images/doorRotated.png")));
                        default -> throw new IllegalStateException("Unexpected value: " + Character.getNumericValue(text.charAt(j)));
                    };
                }
            }
        } catch (IOException | IllegalStateException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                final BufferedImage tile = map[j][i].getImg();
                for (int x = 0; x < tile.getWidth(); x++) {
                    for (int y = 0; y < tile.getHeight(); y++) {
                        img.setRGB(x + i * tileSize, y + j * tileSize, tile.getRGB(x, y));
                    }
                }
            }
        }
    }

    public static Tile[][] getMap() {
        return map;
    }
}