package com.roleplay.gui;

import com.roleplay.tools.TileCreator;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GameBoard {

    private BufferedImage img;
    private JPanel boardPanel;

    private final int width = 700;
    private final int height = 550;
    public GameBoard() {

        Dimension dimension = new Dimension(width, height);

        boardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);   // here you should create a compatible BufferedImage
                TileCreator tC = new TileCreator();
                tC.createTiles(img);
                g.drawImage(img, 0, 0, null);
            }
        };

        boardPanel.setPreferredSize(dimension);
        boardPanel.setMaximumSize(dimension);
        boardPanel.setMinimumSize(dimension);

    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }
}
