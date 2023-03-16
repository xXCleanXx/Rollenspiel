package com.roleplay.map;

import com.roleplay.build.Door;
import com.roleplay.tools.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class MapCreator {
    private static Tile<?>[][] map;

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

                for (int j = 0; j < columns; j++) {
                    Tile<MapElementProperties> tile;
                    MapElementProperties tileProperties;

                    switch (Character.getNumericValue(text.charAt(j))) {
                        case 0 -> {
                            tileProperties = new MapElementProperties("gras", new Point(i,j), ImageUtils.loadImage("src/com/roleplay/resources/images/background.png"));
                            tile = new Tile<>(tileProperties);
                        }
                        case 1 -> {
                            tileProperties = new MapElementProperties("way", new Point(i,j), ImageUtils.loadImage("src/com/roleplay/resources/images/way.png"));
                            tileProperties.getHitBox().setEnabled(false);
                            tile = new Tile<>(tileProperties);
                        }
                        case 2 -> {
                            tileProperties = new MapElementProperties("water", new Point(i,j), ImageUtils.loadImage("src/com/roleplay/resources/images/water.png"));
                            tile = new Tile<>(tileProperties);

                        }
                        case 3 -> tile = new Door(1, new MapElementProperties("door", new Point(i,j), ImageUtils.loadImage("src/com/roleplay/resources/images/door.png")));
                        case 4 -> tile = new Door(1, new MapElementProperties("doorRotated", new Point(i,j), ImageUtils.loadImage("src/com/roleplay/resources/images/doorRotated.png")));
                        case 5 -> {
                            tileProperties = new MapElementProperties("wall", new Point(i,j), ImageUtils.loadImage("src/com/roleplay/resources/images/wall.png"));
                            tile = new Tile<>(tileProperties);
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + Character.getNumericValue(text.charAt(j)));
                    }

                    map[i][j] = tile;
                }
            }
        } catch (IOException | IllegalStateException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                final BufferedImage tile = map[j][i].getProperties().getTexture();

                if (tile == null) continue;

                for (int x = 0; x < tile.getWidth(); x++) {
                    for (int y = 0; y < tile.getHeight(); y++) {
                        img.setRGB(x + i * tileSize, y + j * tileSize, tile.getRGB(x, y));
                    }
                }
            }
        }
    }

    public static Tile<?>[][] getMap() {
        return map;
    }
}