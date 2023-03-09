package com.roleplay.gui;


import com.roleplay.tools.Image;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ArtefactPanel {

    JPanel artefactPanel;
    private JButton btn_menu;
    private JButton btn_artefact;
    private JLabel title;
    private JLabel subTitle;
    private JButton btn_Arrow;
    private JButton btn_Axe;
    private JButton btn_Bow;
    private JButton btn_Dagger;
    private JButton btn_Dart;
    private JButton btn_HandAxe;
    private JButton btn_Spear;
    private JButton btn_Sword;
    private JButton btn_Chain;
    private JButton btn_Iron;
    private JButton btn_Leather;
    private JButton btn_Shield;
    private JButton btn_Amulet;
    private JButton btn_Cape;
    private JButton btn_Potion;
    private JButton btn_Ring;

    ArtefactPanel(JPanel contentPane) {

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("SETTINGS_PANEL"));
        });

        btn_Amulet.addActionListener(e -> {
            if (true){
                btn_Amulet.setIcon(new ImageIcon(Objects.requireNonNull(Image.loadImage("src/com/roleplay/resources/images/buttons/btn_amulet_disable.png"))));
            }else{
                btn_Amulet.setIcon(new ImageIcon(Objects.requireNonNull(Image.loadImage("src/com/roleplay/resources/images/buttons/btn_amulet_enable.png"))));
            }
        });

    }


    public JPanel getArtefactPanel() {
        return artefactPanel;
    }
}
