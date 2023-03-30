package com.roleplay.gui;

import com.roleplay.tools.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class EndInfoPanel extends JPanel {
    private JPanel infoPanel;
    private JButton btn_end;

    public EndInfoPanel() {
        setOpaque(false);
        setVisible(false);
        add(infoPanel);

        btn_end.addActionListener(e -> {
            setVisible(false);
            GameFrame.close();
        });
    }

    private void createUIComponents() {
        infoPanel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/backgrounds/background_info.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }
}
