package com.roleplay.gui;

import com.roleplay.Factories.KeyFactory;
import com.roleplay.interfaces.IObserver;
import com.roleplay.map.GameMap;
import com.roleplay.map.GameMapCreator;
import com.roleplay.map.Settings;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame implements IObserver {
    private BoardPanel board;
    private ControlPanel gameControl;

    private static GameFrame gameFrame;

    public GameFrame(Settings settings) {
        super();
        initialize(settings);
    }

    private void initialize(Settings settings) {
        setTitle("Nerds vs Monsters");

        GameMap gameMap = GameMapCreator.loadRandomMap();
        gameMap.setSettings(settings);

        board = new BoardPanel(gameMap);
        add(board, BorderLayout.CENTER);
        gameControl = new ControlPanel(gameMap);
        add(gameControl, BorderLayout.EAST);
        PlayerListPanel playerList = new PlayerListPanel(settings);
        add(playerList, BorderLayout.WEST);

        KeyFactory keyFactory = new KeyFactory(settings);
        keyFactory.addKeyBindings(this);

        revalidate();
        repaint();

        setResizable(false);
        pack();

        gameFrame = this;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public BoardPanel getBoard() {
        return this.board;
    }

    @Override
    public void update() {
        board.update();
        gameControl.update();
    }

    public static void close() {
        gameFrame.dispose();
    }
}