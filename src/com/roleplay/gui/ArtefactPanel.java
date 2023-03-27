package com.roleplay.gui;


import com.roleplay.map.Settings;
import com.roleplay.tools.ImageUtils;
import com.roleplay.tools.Messages;
import com.roleplay.tools.Strings;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ArtefactPanel {
    JPanel artefactPanel;
    private JButton btn_menu;
    private JButton btn_artefact;
    private JLabel title;
    private JLabel subTitle;
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
    private final Settings settings;

    ArtefactPanel(JPanel contentPane, Settings settings) {
        this.settings = settings;

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("SETTINGS_PANEL"));
        });

        btn_Amulet.addActionListener(e -> changeIconandBlacklist(Strings.getString("amulet"), btn_Amulet));
        btn_Cape.addActionListener(e -> changeIconandBlacklist(Strings.getString("cape"), btn_Cape));
        btn_Potion.addActionListener(e -> changeIconandBlacklist(Strings.getString("potion"), btn_Potion));
        btn_Ring.addActionListener(e -> changeIconandBlacklist(Strings.getString("ring"), btn_Ring));
        btn_Leather.addActionListener(e -> changeIconandBlacklist(Strings.getString("leather"), btn_Leather));
        btn_Chain.addActionListener(e -> changeIconandBlacklist(Strings.getString("chain"), btn_Chain));
        btn_Iron.addActionListener(e -> changeIconandBlacklist(Strings.getString("iron"), btn_Iron));
        btn_Shield.addActionListener(e -> changeIconandBlacklist(Strings.getString("shield"), btn_Shield));
        btn_Axe.addActionListener(e -> changeIconandBlacklist(Strings.getString("axe"), btn_Axe));
        btn_Bow.addActionListener(e -> changeIconandBlacklist(Strings.getString("bow"), btn_Bow));
        btn_Dagger.addActionListener(e -> changeIconandBlacklist(Strings.getString("dagger"), btn_Dagger));
        btn_Dart.addActionListener(e -> changeIconandBlacklist(Strings.getString("dart"), btn_Dart));
        btn_HandAxe.addActionListener(e -> changeIconandBlacklist(Strings.getString("handAxe"), btn_HandAxe));
        btn_Spear.addActionListener(e -> changeIconandBlacklist(Strings.getString("spear"), btn_Spear));
        btn_Sword.addActionListener(e -> changeIconandBlacklist(Strings.getString("sword"), btn_Sword));

    }

    private void changeIconandBlacklist(String name, JButton button) {
        if (settings.containsArtefactInBlacklist(name)) {
            button.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_" + name + "_enable.png"))));
            settings.removeArtefactFromBlacklist(name);
        } else {
            button.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_" + name + "_disable.png"))));
            settings.addArtefactToBlacklist(name);
        }
    }

    public JPanel getArtefactPanel() {
        return artefactPanel;
    }

    private void createUIComponents() {
        artefactPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/backgrounds/artefact_background2.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();

            }

        };
    }
}
