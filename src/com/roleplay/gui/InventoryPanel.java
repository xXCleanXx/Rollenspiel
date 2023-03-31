package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.items.Inventory;
import com.roleplay.items.armors.Armor;
import com.roleplay.items.armors.Shield;
import com.roleplay.items.artefacts.Artefact;
import com.roleplay.items.weapons.Weapon;
import com.roleplay.map.Settings;
import com.roleplay.tools.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class InventoryPanel extends JPanel {
    private JPanel inventoryPanel;
    private JLabel charcterPicture;
    private JLabel lbl_armor;
    private JLabel lbl_wepons;
    private JLabel lbl_shield;
    private JLabel lbl_00;
    private JLabel lbl_01;
    private JLabel lbl_02;
    private JLabel lbl_03;
    private JLabel lbl_04;
    private JLabel lbl_10;
    private JLabel lbl_11;
    private JLabel lbl_12;
    private JLabel lbl_13;
    private JLabel lbl_14;
    private JLabel lbl_20;
    private JLabel lbl_21;
    private JLabel lbl_22;
    private JLabel lbl_23;
    private JLabel lbl_24;
    private Inventory inventory;
    private final ArrayList<JLabel> labelList = new ArrayList<>();
    private final MouseListener listener = new DragMouseAdapter();
    private final Settings settings;

    private Character character;

    public InventoryPanel(Settings settings) {
        this.settings = settings;
        setOpaque(false);
        setVisible(false);
        add(inventoryPanel);

        lbl_armor.addMouseListener(listener);
        lbl_wepons.addMouseListener(listener);
        lbl_shield.addMouseListener(listener);

        labelList.add(lbl_00);
        labelList.add(lbl_01);
        labelList.add(lbl_02);
        labelList.add(lbl_03);
        labelList.add(lbl_04);
        labelList.add(lbl_10);
        labelList.add(lbl_11);
        labelList.add(lbl_12);
        labelList.add(lbl_13);
        labelList.add(lbl_14);
        labelList.add(lbl_20);
        labelList.add(lbl_21);
        labelList.add(lbl_22);
        labelList.add(lbl_23);
        labelList.add(lbl_24);

        setListenerTransferHAndler();
    }

    private class DragMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel c = (JLabel) e.getSource();
            if (c == lbl_armor) {
                final int i = inventory.add(inventory.getArmor());
                labelList.get(i).setIcon(new ImageIcon(inventory.get(i).getProperties().getTexture32()));
                lbl_armor.setIcon(null);
                inventory.setArmor(null);
            } else if (c == lbl_wepons) {
                final int i = inventory.add(inventory.getFirstHand());
                labelList.get(i).setIcon(new ImageIcon(inventory.get(i).getProperties().getTexture32()));
                lbl_wepons.setIcon(null);
                inventory.setFirstHand(null);
            } else if (c == lbl_shield) {
                final int i = inventory.add(inventory.getSecondHand());
                labelList.get(i).setIcon(new ImageIcon(inventory.get(i).getProperties().getTexture32()));
                lbl_shield.setIcon(null);
                inventory.setSecondHand(null);
            } else {
                int index = labelList.indexOf(c);
                //Wenn inventory null wirft NPE, wird nicht behandelt.
                var item = inventory.get(index);

                if (item instanceof Shield && inventory.getSecondHand() == null) {
                    inventory.setSecondHand(item);
                    lbl_shield.setIcon(new ImageIcon(inventory.getSecondHand().getProperties().getTexture32()));
                    inventory.remove(index);
                    c.setIcon(null);
                } else if (item instanceof Weapon && inventory.getFirstHand() == null) {
                    inventory.setFirstHand(item);
                    lbl_wepons.setIcon(new ImageIcon(inventory.getFirstHand().getProperties().getTexture32()));
                    inventory.remove(index);
                    c.setIcon(null);
                } else if (item instanceof Armor && inventory.getArmor() == null) {
                    inventory.setArmor((Armor) item);
                    lbl_armor.setIcon(new ImageIcon(inventory.getArmor().getProperties().getTexture32()));
                    inventory.remove(index);
                    c.setIcon(null);
                } else if (item instanceof Artefact) {
                    ((Artefact) item).use(character);
                    inventory.remove(index);
                    c.setIcon(null);
                }
            }
        }
    }

    public void initialize() {
        for (Character character : this.settings.getPlayers()) {
            if (character.getProperties().isMyTurn()) {
                inventory = character.getProperties().getInventory();
                charcterPicture.setIcon(new ImageIcon(character.getProperties().getTexture100()));
                this.character = character;
                break;
            }
        }

        try {
            lbl_armor.setIcon(new ImageIcon(inventory.getArmor().getProperties().getTexture32()));
        } catch (Exception ignored) {
        }
        try {
            lbl_wepons.setIcon(new ImageIcon(inventory.getFirstHand().getProperties().getTexture32()));
        } catch (Exception ignored) {
        }
        try {
            lbl_shield.setIcon(new ImageIcon(inventory.getSecondHand().getProperties().getTexture32()));
        } catch (Exception ignored) {
        }
        setLblIcons();
    }

    private void setListenerTransferHAndler() {
        for (JLabel label : labelList) {
            label.addMouseListener(listener);
        }
    }

    private void setLblIcons() {
        for (int i = 0; i < labelList.size(); i++) {
            try {
                labelList.get(i).setIcon(new ImageIcon(inventory.get(i).getProperties().getTexture32()));
            } catch (Exception ignored) {
                break;
            }
        }
    }

    private void createUIComponents() {
        inventoryPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("com/roleplay/resources/images/backgrounds/Inventory_Background.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }

}
