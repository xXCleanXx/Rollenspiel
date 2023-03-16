package com.roleplay.gui;

import com.roleplay.characters.Character;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {


    public GameFrame(ArrayList<Character> player){
        super();
        initialize(player);
    }
        private void initialize(ArrayList<Character> player){
            setTitle("Nerds vs Monsters");

            JMenuBar controlBar = new JMenuBar();
            controlBar.add(new JMenu("Settings"));
            setJMenuBar(controlBar);

            GameBoard board = new GameBoard(player);
            add(board, BorderLayout.CENTER);

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


   /* public static void main(String args[]){
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               new GameFrame();
           }
       });
    }*/
}
