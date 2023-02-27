package com.roleplay.gui;

import com.roleplay.tools.Image;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;

public class CharacterPanel {

    private JPanel characterPanel;
    private JLabel charcterPicture;

    private int player = 0;
    private JLabel title;
    private JLabel subTitle;
    private JButton btn_menu;
    private JButton btn_charcter;
    private JButton btn_wizard;
    private JButton btn_Fighter;
    private JButton btn_thief;
    private JTextField playerName;
    private JButton nextFinish;

    CharacterPanel(JPanel contentPane) {

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        btn_charcter.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("ARTEFACT_PANEL"));
        });

        btn_Fighter.addActionListener(e -> charcterPicture.setIcon(new ImageIcon(Image.loadImage("src/com/roleplay/resources/images/player_Big.png"))));
        btn_wizard.addActionListener(e -> charcterPicture.setIcon(new ImageIcon(Image.loadImage("src/com/roleplay/resources/images/player_Big.png"))));
        btn_thief.addActionListener(e -> charcterPicture.setIcon(new ImageIcon(Image.loadImage("src/com/roleplay/resources/images/player_Big.png"))));

        playerName.addActionListener(e -> System.out.print(playerName.getText()));
        nextFinish.addActionListener(e -> {
        });
    }


    public JPanel getCharacterPanel() {
        return characterPanel;
    }
}
