package com.roleplay.gui;

import com.roleplay.map.Settings;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super();

        initialize();
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    private void initialize() {
        setTitle(Messages.getString("MvsN"));
        setSize(new Dimension(1200, 800));

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new CardLayout());
        Settings settings = new Settings();

        MainPanel main = new MainPanel(contentPane, this, settings);
        CharacterPanel characterPanel = new CharacterPanel(contentPane, settings);
        ArtefactPanel artefactPanel = new ArtefactPanel(contentPane, settings);
        SettingsPanel settingsPanel = new SettingsPanel(contentPane, settings);

        contentPane.add(main.getMainPanel(), Messages.getString("MAIN_PANEL"));
        contentPane.add(characterPanel.getCharacterPanel(), Messages.getString("CHARACTER_PANEL"));
        contentPane.add(artefactPanel.getArtefactPanel(), Messages.getString("ARTEFACT_PANEL"));
        contentPane.add(settingsPanel.getSettingsPanel(), Messages.getString("SETTINGS_PANEL"));

        setContentPane(contentPane);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
    }
}