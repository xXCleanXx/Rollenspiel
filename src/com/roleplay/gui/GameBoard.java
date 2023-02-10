package com.roleplay.gui;

import com.roleplay.tools.TileCreator;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GameBoard {

    private BufferedImage img;
    private JPanel boardPanel;
    public GameBoard() {

        boardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                img = new BufferedImage(700, 550, BufferedImage.TYPE_INT_ARGB);   // here you should create a compatible BufferedImage
                TileCreator tC = new TileCreator();
                tC.createTiles(img);
                g.drawImage(img, 0, 0, null);
            }
        };

    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }
}
