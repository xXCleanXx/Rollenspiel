package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private static MainPanel main;

    private final ArrayList<String> artefactBlackList = new ArrayList<>();

    private static int playerCount = 3;
    private static ArrayList<Character> characterList = new ArrayList<>(3);

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

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new CardLayout());

        main = new MainPanel(contentPane, this);
        CharacterPanel character = new CharacterPanel(contentPane, this);
        ArtefactPanel artefact = new ArtefactPanel(contentPane, this);
        SettingsPanel settings = new SettingsPanel(contentPane);

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


    public static void main(String[] args) {
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
            characterNames.add(character.getProperties().getDisplayName());
        }
        return characterNames;
    }

    public void removeArtefactfromBlackList(String artefact) {
        this.artefactBlackList.remove(artefact);
    }

    public void addArtefactToBlackList(String artefact) {
        this.artefactBlackList.add(artefact);
    }

    public boolean containsArtefactInBlackList(String artefact) {
        return this.artefactBlackList.contains(artefact);
    }
}
