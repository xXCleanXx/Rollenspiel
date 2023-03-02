package com.roleplay.gui;

import com.roleplay.tiles.characters.*;
import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;
import com.roleplay.tools.Image;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;
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
    private JButton btn_Dwarf;
    private JButton btn_Human;
    private JButton btn_Elf;
    private JButton btn_Hobbit;
    private Character character;

    CharacterPanel(JPanel contentPane) {

        this.character = new Warrior(new CharacterProperties("warrior", new Point(0, 0), Image.loadImage("src/com/roleplay/resources/images/player/fighter1_32x32.png")));

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        btn_charcter.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("ARTEFACT_PANEL"));
        });

        btn_Dwarf.addActionListener(e -> {

        });

        btn_Human.addActionListener(e -> {

        });

        btn_Elf.addActionListener(e -> {

        });

        btn_Hobbit.addActionListener(e -> {

        });

        btn_Fighter.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(Objects.requireNonNull(Image.loadImage("src/com/roleplay/resources/images/player/fighter1_300x300.png"))));
            this.character = new Warrior(new CharacterProperties("Warrior", new Point(0, 0), Image.loadImage("src/com/roleplay/resources/images/player/fighter1_32x32.png")));
        });
        btn_wizard.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(Objects.requireNonNull(Image.loadImage("src/com/roleplay/resources/images/player/wizard1_300x300.png"))));
            this.character = new Wizard(new CharacterProperties("Wizard", new Point(0, 1), Image.loadImage("src/com/roleplay/resources/images/player/wizard1_32x32.png")));
        });
        btn_thief.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(Objects.requireNonNull(Image.loadImage("src/com/roleplay/resources/images/player/fighter2_300x300.png"))));
            this.character = new Thief(new CharacterProperties("Thief", new Point(1, 0), Image.loadImage("src/com/roleplay/resources/images/player/fighter2_32x32.png")));
        });

        nextFinish.addActionListener(e -> {
            ((CharacterProperties) this.character.getProperties()).setDisplayName(playerName.getText());

            MainFrame.addCharactertoList(this.character);
            playerName.setText("");
        });
    }

    public JPanel getCharacterPanel() {
        return characterPanel;
    }
}
