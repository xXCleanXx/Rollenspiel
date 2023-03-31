package com.roleplay.gui;

import com.roleplay.tools.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class StartInfoPanel extends JPanel{
    private JPanel infoPanel;
    private JButton btn_start;
    private JTextArea alsGruppeVonNerdsTextArea;

    public StartInfoPanel(){
        setOpaque(false);
        add(infoPanel);

        btn_start.addActionListener(e -> {
            setVisible(false);
        });
    }

    private void createUIComponents() {
        infoPanel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("com/roleplay/resources/images/backgrounds/background_info.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }
}
