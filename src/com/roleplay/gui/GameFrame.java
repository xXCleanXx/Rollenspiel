package com.roleplay.gui;

import com.roleplay.Factories.KeyFactory;
import com.roleplay.characters.Character;
import com.roleplay.interfaces.IObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame implements IObserver {
    private BoardPanel board;
    private PlayerListPanel playerList;
    private ControlPanel gameControl;
    public GameFrame(ArrayList<Character> player) {
        super();
        initialize(player);
    }

    private void initialize(ArrayList<Character> player) {
        setTitle("Nerds vs Monsters");

        JMenuBar controlBar = new JMenuBar();
        controlBar.add(new JMenu("Settings"));
        setJMenuBar(controlBar);

        board = new BoardPanel(player);
        add(board, BorderLayout.CENTER);
        gameControl = new ControlPanel();
        add(gameControl, BorderLayout.EAST);
        playerList = new PlayerListPanel();
        add(playerList, BorderLayout.WEST);

        KeyFactory keyFactory = new KeyFactory();
        keyFactory.addKeyBindings(this);


        revalidate();
        repaint();

        setResizable(false);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public BoardPanel getBoard(){
        return this.board;
    }

    @Override
    public void update() {
        board.update();
        playerList.update();
        gameControl.update();
    }
}
