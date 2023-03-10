package com.roleplay.gui;

import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;
import com.roleplay.tiles.properties.Difficult;
import com.roleplay.tools.ImageUtils;
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
            if (MainFrame.getCharacterList().size() >= 4) {
                mainFrame.setVisible(false);
                new GameFrame(MainFrame.getCharacterList());
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setCharacterJList(ArrayList<Character> charachterList) {
        String[] charachterObject = new String[8];
        for (int i = 0; i < charachterList.size(); i++) {
            Character character = charachterList.get(i);
            //charachterObject[i] = "Player " + (i + 1) + ": " + ((CharacterProperties) character.getProperties()).getDisplayName() + ",\n Typ: " + character.getClass().getSimpleName();
            charachterObject[i] = (i + 1) + ": " + ((CharacterProperties) character.getProperties()).getDisplayName() + "," + character.getClass().getSimpleName();
        }
        listCharacter.setListData(charachterObject);
    }

    private void createUIComponents() {
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if(SettingsPanel.getDifficult() == Difficult.HARD) {
                    g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/Background_main_2.png"), 0, 0, this);
                }else if(SettingsPanel.getDifficult() == Difficult.HARDCORE) {
                    g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/Background_main_3.png"), 0, 0, this);
                }else{
                    g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/Background_main_1.png"), 0, 0, this);
                }
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }
}
