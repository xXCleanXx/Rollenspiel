package com.roleplay.gui;


import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;

public class ArtefactPanel {

    JPanel artefactPanel;
    private JButton btn_menu;
    private JButton btn_artefact;
    private JLabel title;
    private JLabel subTitle;

    ArtefactPanel(JPanel contentPane) {

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });


        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("SETTINGS_PANEL"));
        });

    }

    public JPanel getArtefactPanel() {
        return artefactPanel;
    }
}
