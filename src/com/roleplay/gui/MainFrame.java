package com.roleplay.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public MainFrame(){
        super();
        initialize();
    }
    private void initialize(){
        setTitle("Nerds vs Monsters");
        setMinimumSize(new Dimension(1200,800));

        MainPanel main = new MainPanel();

        add(main.getMainPanel(), BorderLayout.CENTER);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    //public static void main(String args[]){
    //   new MainFrame();
    // }
}
