package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.enums.Difficult;
import com.roleplay.tools.ImageUtils;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SettingsPanel {

    private JPanel settingsPanel;

    private JButton btn_menu;
    private JButton btn_artefact;
    private JLabel title;
    private JLabel subTitle;
    private JButton btn_4player;
    private JButton btn_5player;
    private JButton btn_6player;
    private JButton btn_7player;
    private JButton btn_8player;
    private JComboBox box_difficult;

    private static Difficult difficult = Difficult.EASY;

    SettingsPanel(JPanel contentPane) {
        btn_4player.addActionListener(e -> setPlayer(4));
        btn_5player.addActionListener(e -> setPlayer(5));
        btn_6player.addActionListener(e -> setPlayer(6));
        btn_7player.addActionListener(e -> setPlayer(7));
        btn_8player.addActionListener(e -> setPlayer(8));

        box_difficult.addActionListener(e -> setDifficult(box_difficult.getSelectedIndex()));

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });

        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("CHARACTER_PANEL"));
        });
    }

    private void setPlayer(int playerCount) {
        MainFrame.setPlayer(playerCount);
        ArrayList<Character> oldCharacterList = MainFrame.getCharacterList();
        if (oldCharacterList.isEmpty()) {
            MainFrame.setCharacterList(new ArrayList<>(playerCount));
            return;
        }
        if (playerCount == oldCharacterList.size()) {
            return;
        }
        ArrayList<Character> newcharacterList = new ArrayList<>(playerCount);

        if (playerCount > oldCharacterList.size()) {
            newcharacterList.addAll(oldCharacterList);
        } else {
            for (int i = 0; i < playerCount; i++) {
                newcharacterList.add(oldCharacterList.get(i));
            }
        }
        MainFrame.setCharacterList(newcharacterList);

    }

    private void setDifficult(int i) {
        switch (i) {
            case 0 -> difficult = Difficult.EASY;
            case 1 -> difficult = Difficult.MEDIUM;
            case 2 -> difficult = Difficult.HARD;
            case 3 -> difficult = Difficult.HARDCORE;
        }
    }

    public static Difficult getDifficult() {
        return difficult;
    }

    public JPanel getSettingsPanel() {
        return settingsPanel;
    }

    private void createUIComponents() {
        final String[] difficult = {Messages.getString("easy"), Messages.getString("medium"), Messages.getString("hard"), Messages.getString("hardcore")};

        box_difficult = new JComboBox<>(difficult);

        settingsPanel = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/artefact_background3.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();
            }

        };
    }
}
