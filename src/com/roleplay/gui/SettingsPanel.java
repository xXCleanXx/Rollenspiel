package com.roleplay.gui;

import com.roleplay.characters.enums.Difficulty;
import com.roleplay.map.Settings;
import com.roleplay.tools.ImageUtils;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SettingsPanel {
    private JPanel settingsPanel;
    private JButton btn_menu;
    private JButton btn_artefact;
    private JLabel title;
    private JButton btn_3player;
    private JButton btn_4player;
    private JButton btn_5player;
    private JButton btn_6player;
    private JComboBox<String> box_difficult;
    private final Settings settings;

    SettingsPanel(JPanel contentPane, Settings settings) {
        this.settings = settings;

        setButton(btn_3player, 3);
        setButton(btn_4player, 4);
        setButton(btn_5player, 5);
        setButton(btn_6player, 6);

        box_difficult.addActionListener(e -> {
            int i = box_difficult.getSelectedIndex();

            if (i < 0) return;

            settings.setDifficulty(Difficulty.values()[i]);
        });

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });

        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("CHARACTER_PANEL"));
        });
    }

    private void setButton(JButton button, int playerCount) {
        button.addActionListener(e -> {
            settings.setPlayerCount(playerCount);
            resetIcons();
            button.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("com/roleplay/resources/images/buttons/btn_60x40_enable.png"))));
        });
    }

    private void resetIcon(JButton button) {
        button.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("com/roleplay/resources/images/buttons/btn_60x40.png"))));
    }

    private void resetIcons(){
        resetIcon(btn_3player);
        resetIcon(btn_4player);
        resetIcon(btn_5player);
        resetIcon(btn_6player);
    }

    public JPanel getSettingsPanel() {
        return settingsPanel;
    }

    private void createUIComponents() {
        String[] difficult = {
                Messages.getString("easy"),
                Messages.getString("medium"),
                Messages.getString("hard"),
                Messages.getString("hardcore")
        };

        box_difficult = new JComboBox<>(difficult);
        settingsPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("com/roleplay/resources/images/backgrounds/artefact_background3.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }
}