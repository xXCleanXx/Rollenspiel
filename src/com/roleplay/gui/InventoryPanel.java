package com.roleplay.gui;

import com.roleplay.tools.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

        MouseListener listener = new DragMouseAdapter();

        lbl_armor.addMouseListener(listener);
        lbl_armor.setTransferHandler(new TransferHandler("icon"));

        lbl_wepons.addMouseListener(listener);
        lbl_wepons.setTransferHandler(new TransferHandler("icon"));

        lbl_shield.addMouseListener(listener);
        lbl_shield.setTransferHandler(new TransferHandler("icon"));

        lbl_00.addMouseListener(listener);
        lbl_00.setTransferHandler(new TransferHandler("icon"));

        lbl_01.addMouseListener(listener);
        lbl_01.setTransferHandler(new TransferHandler("icon"));

        lbl_02.addMouseListener(listener);
        lbl_02.setTransferHandler(new TransferHandler("icon"));

        lbl_03.addMouseListener(listener);
        lbl_03.setTransferHandler(new TransferHandler("icon"));

        lbl_04.addMouseListener(listener);
        lbl_04.setTransferHandler(new TransferHandler("icon"));

        lbl_10.addMouseListener(listener);
        lbl_10.setTransferHandler(new TransferHandler("icon"));

        lbl_11.addMouseListener(listener);
        lbl_11.setTransferHandler(new TransferHandler("icon"));

        lbl_12.addMouseListener(listener);
        lbl_12.setTransferHandler(new TransferHandler("icon"));

        lbl_13.addMouseListener(listener);
        lbl_13.setTransferHandler(new TransferHandler("icon"));

        lbl_14.addMouseListener(listener);
        lbl_14.setTransferHandler(new TransferHandler("icon"));

        lbl_20.addMouseListener(listener);
        lbl_20.setTransferHandler(new TransferHandler("icon"));

        lbl_21.addMouseListener(listener);
        lbl_21.setTransferHandler(new TransferHandler("icon"));

        lbl_22.addMouseListener(listener);
        lbl_22.setTransferHandler(new TransferHandler("icon"));

        lbl_23.addMouseListener(listener);
        lbl_23.setTransferHandler(new TransferHandler("icon"));

        lbl_24.addMouseListener(listener);
        lbl_24.setTransferHandler(new TransferHandler("icon"));
    }

    private class DragMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            JComponent c = (JComponent) e.getSource();
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.COPY);
            ((JLabel)c).setIcon(null);
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
