package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.items.Inventory;
import com.roleplay.tools.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

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

    public InventoryPanel() {
        setOpaque(false);
        setVisible(false);
        add(inventoryPanel);

        lbl_armor.addMouseListener(listener);
        lbl_armor.setTransferHandler(new TransferHandler("icon"));

        lbl_wepons.addMouseListener(listener);
        lbl_wepons.setTransferHandler(new TransferHandler("icon"));

        lbl_shield.addMouseListener(listener);
        lbl_shield.setTransferHandler(new TransferHandler("icon"));

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
        public void mousePressed(MouseEvent e) {
            System.out.println("1: ");
            System.out.println(e);
            JComponent c = (JComponent) e.getSource();
            System.out.println(c);
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.MOVE);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("2: ");
            System.out.println(e);
            JComponent c = (JComponent) e.getSource();
            System.out.println(c);
        }

    }

    public void initialize() {
        for (Character character : MainFrame.getCharacterList()) {
            if (character.getProperties().isMyTurn()) {
                inventory = character.getProperties().getInventory();
                break;
            }
        }
        try {
            setIcon(lbl_armor, inventory.getArmor().getProperties().getName());
        } catch (Exception ignored) {

        }
        try {
            setIcon(lbl_wepons, inventory.getFirstHand().getProperties().getName());
        } catch (Exception ignored) {

        }
        try {
            setIcon(lbl_shield, inventory.getSecondHand().getProperties().getName());
        } catch (Exception ignored) {

        }
        setLblIcons();
    }

    private void setIcon(JLabel label, String name) {
        if (!name.isEmpty()) {
            label.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/items/" + name + "_32x32.png"))));
        }
    }

    private void setListenerTransferHAndler() {
        for (JLabel label : labelList) {
            label.addMouseListener(listener);
            label.setTransferHandler(new TransferHandler("icon"));
        }
    }

    private void setLblIcons() {
        int counterInventory = 0;
        for (JLabel label : labelList) {
            try {
                setIcon(label, inventory.get(counterInventory).getProperties().getName());
            } catch (Exception ignored) {
            }
            counterInventory++;
        }
    }

    private void createUIComponents() {
        inventoryPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/Inventory_Background.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }

}
