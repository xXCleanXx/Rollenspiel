package com.roleplay.gui;

import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;

public class MainPanel {

    private JPanel mainPanel;
    private JButton btn_Settings;
    private JButton btn_Character;
    private JButton btn_Artefact;


    MainPanel(JPanel contentPane) {
        btn_Settings.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("SETTINGS_PANEL"));
        });
        mainPanel.add(btn_Settings);

        btn_Character.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("CHARACTER_PANEL"));
        });
        mainPanel.add(btn_Character);

        btn_Artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("ARTEFACT_PANEL"));
        });
        mainPanel.add(btn_Artefact);

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


}
