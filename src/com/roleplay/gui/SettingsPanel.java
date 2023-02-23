package com.roleplay.gui;

import com.roleplay.messages.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class SettingsPanel {

    JPanel settingsPanel;

    SettingsPanel(JPanel contentPane) {
        settingsPanel = new JPanel(new BorderLayout());
        //settingsPanel.add(pageStart(), BorderLayout.PAGE_START);
        //settingsPanel.add(lineStart(), BorderLayout.LINE_START);
        settingsPanel.add(pageEnd(contentPane), BorderLayout.PAGE_END);
    }

    private JPanel pageEnd(JPanel contentPane) {
        JPanel lineEnd = new JPanel(new GridLayout(3, 1));

        JButton btn_menue = new JButton(Messages.getString("startMenu"));
        btn_menue.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        lineEnd.add(btn_menue);

        JButton btn_artefact = new JButton(Messages.getString("character"));
        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("CHARACTER_PANEL"));
        });
        lineEnd.add(btn_artefact);
        return lineEnd;
    }

    public JPanel getSettingsPanel() {
        return settingsPanel;
    }
}
