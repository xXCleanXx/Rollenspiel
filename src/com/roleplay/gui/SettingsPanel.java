package com.roleplay.gui;

import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel {

    private JPanel settingsPanel;

    private final String[] difficult = {Messages.getString("easy"), Messages.getString("medium"), Messages.getString("hard")};

    SettingsPanel(JPanel contentPane) {
        settingsPanel = new JPanel(new BorderLayout());
        settingsPanel.add(pageStart(), BorderLayout.PAGE_START);
        settingsPanel.add(pageCenter(), BorderLayout.CENTER);
        settingsPanel.add(pageEnd(contentPane), BorderLayout.PAGE_END);
    }

    private JPanel pageStart() {
        JPanel pageStart = new JPanel();
        pageStart.add(new Label(Messages.getString("settings")));
        return pageStart;
    }

    private JPanel pageCenter() {
        JPanel pageCenter = new JPanel();
        pageCenter.add(createPageCenterButtons(4));
        pageCenter.add(createPageCenterButtons(5));
        pageCenter.add(createPageCenterButtons(6));
        pageCenter.add(createPageCenterButtons(7));
        pageCenter.add(createPageCenterButtons(8));

        JComboBox<String> box_difficult = new JComboBox<>(difficult);
        box_difficult.addActionListener(e -> setDifficult((String) box_difficult.getSelectedItem()));
        pageCenter.add(box_difficult);

        return pageCenter;
    }

    private JButton createPageCenterButtons(int player) {
        JButton button = new JButton(Integer.toString(player));
        button.addActionListener(e -> setPlayer(player));
        button.setBackground(new Color(100,100,100));
        return button;
    }

    private void setPlayer(int i) {
    }

    private void setDifficult(String s) {
    }

    private JPanel pageEnd(JPanel contentPane) {
        JPanel pageEnd = new JPanel(new GridLayout(1, 2));

        JButton btn_menue = new JButton(Messages.getString("startMenu"));
        btn_menue.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        pageEnd.add(btn_menue);

        JButton btn_artefact = new JButton(Messages.getString("character"));
        btn_artefact.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("CHARACTER_PANEL"));
        });
        pageEnd.add(btn_artefact);
        return pageEnd;
    }

    public JPanel getSettingsPanel() {
        return settingsPanel;
    }
}
