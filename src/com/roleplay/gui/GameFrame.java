package com.roleplay.gui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(){
        super();
        initialize();
    }
        private void initialize(){
            setTitle("Nerds vs Monsters");

            JMenuBar controlBar = new JMenuBar();
            controlBar.add(new JMenu("Settings"));
            setJMenuBar(controlBar);

            GameBoard board = new GameBoard();
            add(board, BorderLayout.CENTER);

            addKeyListener(board);

            setResizable(false);
            pack();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }


    public static void main(String args[]){
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               new GameFrame();
           }
       });
    }
}
