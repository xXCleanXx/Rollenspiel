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
            setMinimumSize(new Dimension(1200,800));

            GameBoard gameBoard = new GameBoard();

            add(gameBoard.getBoardPanel(), BorderLayout.CENTER);

            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }


    //public static void main(String args[]){
     //   new GameFrame();
   // }
}
