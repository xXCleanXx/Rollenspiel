package com.roleplay.gui;

import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel {

    private JPanel mainPanel;
    private JButton btn_Settings;
    private JButton btn_Character;
    private JButton btn_Artefact;
    private JButton btn_start;
    private JLabel title;
    private JList listCharacter;


    MainPanel(JPanel contentPane, JFrame mainFrame) {
        btn_Settings.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("SETTINGS_PANEL"));
        });

        btn_Character.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("CHARACTER_PANEL"));
        });

        btn_Artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("ARTEFACT_PANEL"));
        });

        btn_start.addActionListener(e -> {
            mainFrame.setVisible(false);
            new GameFrame(MainFrame.getCharacterList());
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setCharacterJList(ArrayList<Character> charachterList) {
        String[] charachterObject = new String[8];
        for (int i = 0; i < charachterList.size(); i++) {
            Character character = charachterList.get(i);
            charachterObject[i] = "Player 1: " + ((CharacterProperties) character.getProperties()).getDisplayName() + ", Typ: " + character.getClass().getSimpleName();
        }
        listCharacter.setListData(charachterObject);


    }

    private void createUIComponents() {

    }
}
