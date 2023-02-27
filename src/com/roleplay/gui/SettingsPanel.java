package com.roleplay.gui;

import com.roleplay.tiles.characters.Character;
import com.roleplay.tools.Messages;
import com.sun.tools.javac.Main;

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

    SettingsPanel(JPanel contentPane) {
        btn_4player.addActionListener(e -> setPlayer(4));
        btn_5player.addActionListener(e -> setPlayer(5));
        btn_6player.addActionListener(e -> setPlayer(6));
        btn_7player.addActionListener(e -> setPlayer(7));
        btn_8player.addActionListener(e -> setPlayer(8));

        box_difficult.addActionListener(e -> setDifficult((String) box_difficult.getSelectedItem()));

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

    private void setDifficult(String s) {
    }

    public JPanel getSettingsPanel() {
        return settingsPanel;
    }

    private void createUIComponents() {
        final String[] difficult = {Messages.getString("easy"), Messages.getString("medium"), Messages.getString("hard")};

        box_difficult = new JComboBox<>(difficult);
    }
}
