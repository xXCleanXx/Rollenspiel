package com.roleplay.gui;

import com.roleplay.messages.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class MainPanel {

    JPanel mainPanel;
    MainPanel(JPanel contentPane) {
        mainPanel = new JPanel();

        JButton btn_Settings = new JButton(Messages.getString("settings"));
        btn_Settings.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane,Messages.getString("SETTINGS_PANEL"));
        });
        mainPanel.add(btn_Settings);

        JButton btn_Character = new JButton(Messages.getString("charcterMenu"));
        btn_Character.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("CHARACTER_PANEL"));
        });
        mainPanel.add(btn_Character);

        JButton btn_Artefact = new JButton(Messages.getString("artefactMenu"));
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
