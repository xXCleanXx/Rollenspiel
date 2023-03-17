package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.map.GameMap;
import com.roleplay.map.GameMapCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameFrame extends JFrame {

    public GameFrame(ArrayList<Character> player) {

    private GameBoard board;

    public GameFrame(ArrayList<Character> player){
        super();
        initialize(player);
    }

    private void initialize(ArrayList<Character> player) {
        setTitle("Nerds vs Monsters");

        JMenuBar controlBar = new JMenuBar();
        controlBar.add(new JMenu("Settings"));
        setJMenuBar(controlBar);

         board = new GameBoard(player);
        add(board, BorderLayout.CENTER);addKeyBindings(board);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                board.setVisible();
            }
        });

        InGamePlayersPanel players = new InGamePlayersPanel(player);
        add(players, BorderLayout.WEST);
ControlPanel gameControl = new ControlPanel();
            add(gameControl, BorderLayout.EAST);        revalidate();
        repaint();

        setResizable(false);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }

    public void addKeyBindings(JComponent jc) {
        setKeyActions("RIGHT", KeyEvent.VK_RIGHT,1,0, jc);
        setKeyActions("LEFT", KeyEvent.VK_LEFT,-1,0, jc);
        setKeyActions("UP", KeyEvent.VK_UP,0,-1,jc);
        setKeyActions("DOWN", KeyEvent.VK_DOWN,0,1, jc);
    }

    private void setKeyActions(String keyName, int key, int dx, int dy, JComponent jc){
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0, false), keyName);
        jc.getActionMap().put(keyName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                for (Character c : MainFrame.getCharacterList()) {
                    if (c.getProperties().isMyTurn()) {
                        if(!board.getGameMap().getMapElements()[c.getProperties().getPosition().y + dy][c.getProperties().getPosition().x + dx].getMapElementProperties().getHitBox().isEnabled()){
                            c.getProperties().getPosition().translate(dx,dy);
                            ControlPanel.setValue(ControlPanel.getValue() -1);
                            ControlPanel.showValue.setText(String.valueOf(ControlPanel.getValue()));
                            if(ControlPanel.getValue() == 0) {
                                c.getProperties().setMyTurn(false);
                                ControlPanel.leftInRound.remove(c);
                                ControlPanel.button.setEnabled(true);
                            }
                        }
                    }

                }
            }
        });

    }


}
