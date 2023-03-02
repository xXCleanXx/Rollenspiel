package com.roleplay.gui;

import com.roleplay.tiles.characters.*;
import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;
import com.roleplay.tools.Image;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

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
    private Character character;

    CharacterPanel(JPanel contentPane) {

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        btn_charcter.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("ARTEFACT_PANEL"));
        });

        btn_Fighter.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(Objects.requireNonNull(Image.loadImage("src/com/roleplay/resources/images/player/fighter1_300x300.png"))));
            this.character = new Warrior(new CharacterProperties("warrior", new Point(0,0), Image.loadImage("src/com/roleplay/resources/images/player/fighter1_32x32.png")));
        });
        btn_wizard.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(Objects.requireNonNull(Image.loadImage("src/com/roleplay/resources/images/player/wizard1_300x300.png"))));
            this.character = new Wizard(new CharacterProperties("wizard", new Point(0,1), Image.loadImage("src/com/roleplay/resources/images/player/wizard1_32x32.png")));
        });
        btn_thief.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(Objects.requireNonNull(Image.loadImage("src/com/roleplay/resources/images/player/fighter2_300x300.png"))));
            this.character = new Thief(new CharacterProperties("thief", new Point(1,0), Image.loadImage("src/com/roleplay/resources/images/player/fighter2_32x32.png")));
        });

        playerName.addActionListener(e -> character.getProperties().setName(playerName.getText()));
        nextFinish.addActionListener(e -> {
            MainFrame.addCharactertoList(character);
            playerName.setText("");
        });
    }

    public JPanel getCharacterPanel() {
        return characterPanel;
    }
}
