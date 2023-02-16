package com.roleplay.tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TileCreator{

    public BufferedImage createTile(final Color c ) {
        final BufferedImage res = new BufferedImage( 20, 20, BufferedImage.TYPE_INT_ARGB );
        for (int x = 0; x < res.getWidth(); x++) {
            for (int y = 0; y < res.getHeight(); y++) {
                res.setRGB( x, y, c.getRGB());
            }
        }
        return res;
    }

    public void createTiles(BufferedImage img){
        final int NB_TILES = 2;
        BufferedImage[] tiles = new BufferedImage[NB_TILES];
        try {
            tiles[0] = ImageIO.read(new File("src/com/roleplay/resources/gras.png"));
            tiles[1] = ImageIO.read(new File("src/com/roleplay/resources/way.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         int[][] map = new int[11][14];
            for (int[]a : map) {
                Arrays.fill(a, 1);
            }

       /* final int[][] map = new int[][] {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1 },
                { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }
        };*/

        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                final BufferedImage tile = tiles[map[j][i]];
                for (int x = 0; x < tile.getWidth(); x++) {
                    for (int y = 0; y < tile.getHeight(); y++) {
                        img.setRGB( x + i * 20, y + j * 20, tile.getRGB(x,y) );
                    }
                }
            }
        }
    }
}