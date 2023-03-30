package com.roleplay.map;

import com.roleplay.build.Chest;
import com.roleplay.build.Door;
import com.roleplay.tools.ImageUtils;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public final class GameMapCreator {
    private GameMapCreator() {
    }

    public static GameMap loadMap(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            GameMap gameMap = new GameMap(lines.get(0).length(), lines.size());

            for (int i = 0; i < gameMap.getHeight(); i++) {
                String text = lines.get(i);

                for (int j = 0; j < gameMap.getWidth(); j++) {
                    Tile<GameMapElementProperties> tile;
                    GameMapElementProperties tileProperties;

                    switch (Character.getNumericValue(text.charAt(j))) {
                        case 0 -> {
                            tileProperties = new GameMapElementProperties("gras", new Point(j, i), ImageUtils.loadImage("src/com/roleplay/resources/images/backgrounds/background.png"));
                            tile = new Tile<>(tileProperties);
                        }
                        case 1 -> {
                            tileProperties = new GameMapElementProperties("way", new Point(i, j), ImageUtils.loadImage("src/com/roleplay/resources/images/way.png"));
                            tileProperties.getHitBox().setEnabled(false);
                            tile = new Tile<>(tileProperties);
                        }
                        case 2 -> {
                            tileProperties = new GameMapElementProperties("water", new Point(j, i), ImageUtils.loadImage("src/com/roleplay/resources/images/water.png"));
                            tile = new Tile<>(tileProperties);
                        }
                        case 3 ->
                                tile = new Door(1, new GameMapElementProperties("door", new Point(j, i), ImageUtils.loadImage("src/com/roleplay/resources/images/door.png")));
                        case 4 ->
                                tile = new Door(1, new GameMapElementProperties("doorRotated", new Point(j, i), ImageUtils.loadImage("src/com/roleplay/resources/images/doorRotated.png")));
                        case 5 -> {
                            tileProperties = new GameMapElementProperties("wall", new Point(j, i), ImageUtils.loadImage("src/com/roleplay/resources/images/wall.png"));
                            tile = new Tile<>(tileProperties);
                        }
                        case 9 -> {
                            tile = new Chest(new GameMapElementProperties("chest", new Point(0, 0), ImageUtils.loadImage("src/com/roleplay/resources/images/chest.png")));
                        }
                        default ->
                                throw new IllegalStateException("Unexpected value: " + Character.getNumericValue(text.charAt(j)));
                    }

                    gameMap.getMapElements()[i][j] = tile;
                }
            }

            return gameMap;
        } catch (IOException e) {
            return null;
        }
    }

    public static GameMap loadRandomMap() {
        Random random = new Random();
        String[] maps = new String[]{
                "map.txt",
                "map1.txt",
                "map2.txt",
        };

        return loadMap("src/com/roleplay/resources/maps/" + maps[random.nextInt(3)]); // TODO: Random load
    }
}