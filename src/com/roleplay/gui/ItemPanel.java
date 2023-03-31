package com.roleplay.gui;


import com.roleplay.Factories.ItemFactory;
import com.roleplay.items.Item;
import com.roleplay.map.Settings;
import com.roleplay.tools.ImageUtils;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ItemPanel {
    JPanel itemPanel;
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

    ItemPanel(JPanel contentPane, Settings settings) {
        this.settings = settings;

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("SETTINGS_PANEL"));
        });

        ItemFactory itemFactory = new ItemFactory(this.settings);
        itemFactory.addAllItems();


        btn_Amulet.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("amulet"), btn_Amulet));
        btn_Cape.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("cape"), btn_Cape));
        btn_Potion.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("potion"), btn_Potion));
        btn_Ring.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("ring"), btn_Ring));
        btn_Leather.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("leather"), btn_Leather));
        btn_Chain.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("chain"), btn_Chain));
        btn_Iron.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("iron"), btn_Iron));
        btn_Shield.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("shield"), btn_Shield));
        btn_Axe.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("axe"), btn_Axe));
        btn_Bow.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("bow"), btn_Bow));
        btn_Dagger.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("dagger"), btn_Dagger));
        btn_Dart.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("dart"), btn_Dart));
        btn_HandAxe.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("handAxe"), btn_HandAxe));
        btn_Spear.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("spear"), btn_Spear));
        btn_Sword.addActionListener(e -> changeIconAndList(itemFactory.getItemByName("sword"), btn_Sword));

    }

    private void changeIconAndList(Item item, JButton button) {
        if (!settings.getItemWhiteList().contains(item)) {
            button.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("com/roleplay/resources/images/buttons/btn_" + item.getProperties().getName() + "_enable.png"))));
            settings.addItemToWhiteList(item);

        } else {
            button.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("com/roleplay/resources/images/buttons/btn_" + item.getProperties().getName() + "_disable.png"))));
            settings.getItemWhiteList().remove(item);
        }
    }

    public JPanel getArtefactPanel() {
        return itemPanel;
    }

    private void createUIComponents() {
        itemPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("com/roleplay/resources/images/backgrounds/artefact_background2.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();

            }

        };
    }
}
