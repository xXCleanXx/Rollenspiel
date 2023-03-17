package com.roleplay.gui;

import com.roleplay.characters.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameFrame extends JFrame {

    public GameFrame(ArrayList<Character> player) {
        super();
        initialize(player);
    }

    private void initialize(ArrayList<Character> player) {
        setTitle("Nerds vs Monsters");

        JMenuBar controlBar = new JMenuBar();
        controlBar.add(new JMenu("Settings"));
        setJMenuBar(controlBar);

        GameBoard board = new GameBoard(player);
        add(board, BorderLayout.CENTER);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                board.setVisible();
            }
        });

        InGamePlayersPanel players = new InGamePlayersPanel(player);
        add(players, BorderLayout.WEST);
        revalidate();
        repaint();

        setResizable(false);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
