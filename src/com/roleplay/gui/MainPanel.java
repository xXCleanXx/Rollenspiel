package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.characters.enums.Difficulty;
import com.roleplay.map.Settings;
import com.roleplay.tools.ImageUtils;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainPanel {
    private JPanel mainPanel;
    private JButton btn_Settings;
    private JButton btn_Character;
    private JButton btn_Artefact;
    private JButton btn_Start;
    private JLabel title;
    private JList<String> listCharacter;
    private JButton btn_Info;
    private final Settings settings;

    MainPanel(JPanel contentPane, JFrame mainFrame, Settings settings) {
        this.settings = settings;

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

        btn_Info.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("INFO_PANEL"));
        });

        btn_Start.addActionListener(e -> {
            if (settings.getPlayers().size() >= 3) {
                mainFrame.setVisible(false);
                new GameFrame(settings);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setCharacterJList(List<Character> characterList) {
        String[] characterObject = new String[6];

        for (int i = 0; i < characterList.size(); i++) {
            Character character = characterList.get(i);
            characterObject[i] = (i + 1) + ": " + character.getProperties().getDisplayName() + "," + character.getClass().getSimpleName();
        }

        listCharacter.setListData(characterObject);
    }

    private void createUIComponents() {
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (settings.getDifficulty() == Difficulty.HARD) {
                    g.drawImage(ImageUtils.loadImage("com/roleplay/resources/images/backgrounds/Background_main_2.png"), 0, 0, this);
                } else if (settings.getDifficulty() == Difficulty.HARDCORE) {
                    g.drawImage(ImageUtils.loadImage("com/roleplay/resources/images/backgrounds/Background_main_3.png"), 0, 0, this);
                } else {
                    g.drawImage(ImageUtils.loadImage("com/roleplay/resources/images/backgrounds/Background_main_1.png"), 0, 0, this);
                }
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }
}
