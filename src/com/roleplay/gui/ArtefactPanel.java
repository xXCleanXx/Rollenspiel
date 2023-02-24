package com.roleplay.gui;

import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;

public class ArtefactPanel extends JPanel {

    JPanel artefactPanel;

    ArtefactPanel(JPanel contentPane) {

        artefactPanel = new JPanel(new BorderLayout());
        artefactPanel.add(pageEnd(contentPane), BorderLayout.PAGE_END);

    }

    private JPanel pageEnd(JPanel contentPane) {
        JPanel pageEnd = new JPanel(new GridLayout(1, 2));

        JButton btn_menue = new JButton(Messages.getString("startMenu"));
        btn_menue.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        pageEnd.add(btn_menue);

        JButton btn_artefact = new JButton(Messages.getString("settings"));
        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("SETTINGS_PANEL"));
        });
        pageEnd.add(btn_artefact);
        return pageEnd;
    }


    public JPanel getArtefactPanel() {
        return artefactPanel;
    }
}
