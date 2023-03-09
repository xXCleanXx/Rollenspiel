package com.roleplay.gui;

import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;
import com.roleplay.tiles.items.Inventory;
import com.roleplay.tools.Messages;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private static MainPanel main;
    private CharacterPanel character;
    private ArtefactPanel artefact;
    private SettingsPanel settings;

    private static int playerCount = 4;
    private static ArrayList<Character> characterList = new ArrayList(4);

    public MainFrame() {
        super();
        initialize();
    }

    public static void setPlayer(int player) {
        playerCount = player;
    }

    public int getPlayer() {
        return playerCount;
    }

    private void initialize() {
        setTitle(Messages.getString("MvsN"));
        setSize(new Dimension(1200, 800));

        contentPane = new JPanel();
        contentPane.setLayout(new CardLayout());

        main = new MainPanel(contentPane, this);
        character = new CharacterPanel(contentPane, this);
        artefact = new ArtefactPanel(contentPane);
        settings = new SettingsPanel(contentPane);

        contentPane.add(main.getMainPanel(), Messages.getString("MAIN_PANEL"));
        contentPane.add(character.getCharacterPanel(), Messages.getString("CHARACTER_PANEL"));
        contentPane.add(artefact.getArtefactPanel(), Messages.getString("ARTEFACT_PANEL"));
        contentPane.add(settings.getSettingsPanel(), Messages.getString("SETTINGS_PANEL"));

        setContentPane(contentPane);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }


    public static void main(String args[]) {
        new MainFrame();
    }

    @Override
    public void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
    }

    public static ArrayList<Character> getCharacterList() {
        return characterList;
    }

    public static void setCharacterList(ArrayList<Character> newCharacterList) {
        characterList = newCharacterList;
        main.setCharacterJList(getCharacterList());
    }

    public void addCharactertoList(Character character) {
        characterList.add(character);
        main.setCharacterJList(getCharacterList());
    }

    public ArrayList<String> getCharacterListNames() {
        ArrayList<String> characterNames = new ArrayList<>();
        for (Character character : characterList) {
            characterNames.add(((CharacterProperties) character.getProperties()).getDisplayName());
        }
        return characterNames;
    }
}
