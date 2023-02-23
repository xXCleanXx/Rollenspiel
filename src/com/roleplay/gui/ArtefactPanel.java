package com.roleplay.gui;

import com.roleplay.messages.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class ArtefactPanel extends JPanel {

    JPanel artefactPanel;

    ArtefactPanel(JPanel contentPane) {

        artefactPanel = new JPanel();
        artefactPanel.add(pageEnd(contentPane));

    }

    private JPanel pageEnd(JPanel contentPane) {
        JPanel lineEnd = new JPanel(new GridLayout(3, 1));

        JButton btn_menue = new JButton(Messages.getString("startMenu"));
        btn_menue.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        lineEnd.add(btn_menue);

        JButton btn_artefact = new JButton(Messages.getString("settings"));
        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("SETTINGS_PANEL"));
        });
        lineEnd.add(btn_artefact);
        return lineEnd;
    }


    public JPanel getArtefactPanel() {
        return artefactPanel;
    }
}
