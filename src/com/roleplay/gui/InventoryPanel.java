package com.roleplay.gui;

import com.roleplay.tools.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    public InventoryPanel() {
        setOpaque(false);
        setVisible(false);
        add(inventoryPanel);

    }

    private class DragMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            JComponent c = (JComponent) e.getSource();
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.MOVE);
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
