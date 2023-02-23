package com.roleplay.gui;

import com.roleplay.messages.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private MainPanel main;
    private CharacterPanel character;
    private ArtefactPanel artefact;
    private SettingsPanel settings;

    public MainFrame() {
        super();
        initialize();
    }

    private void initialize() {
        setTitle("Nerds vs Monsters");
        setMinimumSize(new Dimension(1200, 800));

        contentPane = new JPanel();
        contentPane.setLayout(new CardLayout());

        main = new MainPanel(contentPane);
        character = new CharacterPanel(contentPane);
        artefact = new ArtefactPanel(contentPane);
        settings = new SettingsPanel(contentPane);

        contentPane.add(main.getMainPanel(), Messages.getString("MAIN_PANEL"));
        contentPane.add(character.getCharacterPanel(), Messages.getString("CHARACTER_PANEL"));
        contentPane.add(artefact.getArtefactPanel(), Messages.getString("ARTEFACT_PANEL"));
        contentPane.add(settings.getSettingsPanel(), Messages.getString("SETTINGS_PANEL"));

        setContentPane(contentPane);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String args[]) {
        new MainFrame();
    }

    @Override
    public void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
    }
}
