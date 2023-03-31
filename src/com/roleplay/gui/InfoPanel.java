package com.roleplay.gui;

import com.roleplay.tools.ImageUtils;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;

public class InfoPanel {
    private JButton btn_menu;
    private JLabel title;


    private JPanel infoPanel;

    public InfoPanel(JPanel contentPane) {

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
    }

    public JPanel getInfoPanel() {
        return infoPanel;
    }

    private void createUIComponents() {

        infoPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/backgrounds/Info_Background.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }
}
