package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.characters.*;
import com.roleplay.characters.enums.Races;
import com.roleplay.characters.CharacterProperties;
import com.roleplay.map.Settings;
import com.roleplay.tools.ImageUtils;
import com.roleplay.tools.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class CharacterPanel {

    private JPanel characterPanel;
    private JLabel charcterPicture;
    private int player = 1;
    private JLabel title;
    private JLabel subTitle;
    private JButton btn_menu;
    private JButton btn_charcter;
    private JButton btn_wizard;
    private JButton btn_Fighter;
    private JButton btn_thief;
    private JTextField playerName;
    private JButton nextFinish;
    private JButton btn_Dwarf;
    private JButton btn_Human;
    private JButton btn_Elf;
    private JButton btn_Hobbit;
    private JButton btn_error;
    private Character character;
    private final Settings settings;
    private final Races[] race = {Races.HUMAN};

    CharacterPanel(JPanel contentPane, MainFrame mainFrame, Settings settings) {
        this.settings = settings;
        this.character = new Warrior(new CharacterProperties(new Point(0, 0)));

        subTitle.setText(Messages.getString("player") + " " + player++ + " " + Messages.getString("chooseCharakter"));

        btn_menu.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("MAIN_PANEL"));
        });
        btn_charcter.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, Messages.getString("ARTEFACT_PANEL"));
        });

        btn_Dwarf.addActionListener(e -> {
            race[0] = Races.DWARF;
            btn_Dwarf.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75_enable.png"))));
            btn_Human.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
            btn_Elf.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
            btn_Hobbit.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
        });

        btn_Human.addActionListener(e -> {
            race[0] = Races.HUMAN;
            btn_Dwarf.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
            btn_Human.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75_enable.png"))));
            btn_Elf.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
            btn_Hobbit.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));

        });

        btn_Elf.addActionListener(e -> {
            race[0] = Races.ELF;
            btn_Dwarf.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
            btn_Human.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
            btn_Elf.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75_enable.png"))));
            btn_Hobbit.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
        });

        btn_Hobbit.addActionListener(e -> {
            race[0] = Races.HOBBIT;
            btn_Dwarf.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
            btn_Human.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
            btn_Elf.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75.png"))));
            btn_Hobbit.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_125x75_enable.png"))));
        });

        btn_Fighter.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/player/fighter1_300x300.png"))));
            btn_Fighter.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_fighter_enable.png"))));
            btn_wizard.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_wizard.png"))));
            btn_thief.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_thief.png"))));
        });
        btn_wizard.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/player/wizard1_300x300.png"))));
            btn_Fighter.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_fighter.png"))));
            btn_wizard.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_wizard_enable.png"))));
            btn_thief.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_thief.png"))));
            this.character = new Wizard(new CharacterProperties(new Point(0, 1)));
        });
        btn_thief.addActionListener(e -> {
            charcterPicture.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/player/fighter2_300x300.png"))));
            btn_Fighter.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_fighter.png"))));
            btn_wizard.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_wizard.png"))));
            btn_thief.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/btn_thief_enable.png"))));
            this.character = new Thief(new CharacterProperties(new Point(1, 0)));
        });

        nextFinish.addActionListener(e -> {
            btn_error.setVisible(false);
            try {
                createNextPlayer();
            } catch (IndexOutOfBoundsException IOOBE) {
                btn_error.setText(Messages.getString("exists"));
                btn_error.setVisible(true);
            } catch (NullPointerException NPE) {
                btn_error.setText(Messages.getString("empty"));
                btn_error.setVisible(true);
            }
        });
    }

    private void createNextPlayer() {
        if (playerName.getText().isEmpty()) {
            throw new NullPointerException();
        }

        if (settings.getPlayers().stream().noneMatch(x -> x.getProperties().getDisplayName().equalsIgnoreCase(playerName.getText().trim()))) {
            if (settings.getPlayerCount() == settings.getPlayers().size() && settings.getPlayerCount() != player - 1) {
                settings.getPlayers().get(player - 2).getProperties().setDisplayName(playerName.getText());
                playerName.setText(settings.getPlayers().get(player - 1).getProperties().getDisplayName());

                doClick(player - 1);
            } else if (settings.getPlayers().size() < player - 1) {
                new CharacterCreator(this.character, race[0], playerName.getText());
                settings.addPlayer(this.character);
                playerName.setText("");

                if (this.character instanceof Warrior) {
                    this.character = new Warrior(new CharacterProperties(new Point(0, 0)));
                } else if (this.character instanceof Wizard) {
                    this.character = new Wizard(new CharacterProperties(new Point(0, 1)));
                } else {
                    this.character = new Thief(new CharacterProperties(new Point(1, 0)));
                }
            }

            if (settings.getPlayerCount() == player - 1) {
                this.player = 1;

                subTitle.setText(Messages.getString("player") + " " + this.player + " " + Messages.getString("chooseCharakter"));
                playerName.setText(settings.getPlayers().get(0).getProperties().getDisplayName());

                doClick(0);
            }

            subTitle.setText(Messages.getString("player") + " " + this.player + " " + Messages.getString("chooseCharakter"));
            this.player++;
        }
    }

    private void doClick(int i) {
        final Character tempCharacter = settings.getPlayers().get(i);
        final Races race = tempCharacter.getProperties().getRace();

        if (race == Races.ELF) {
            btn_Elf.doClick();
        } else if (race == Races.DWARF) {
            btn_Dwarf.doClick();
        } else if (race == Races.HOBBIT) {
            btn_Hobbit.doClick();
        } else {
            btn_Human.doClick();
        }

        if (tempCharacter instanceof Warrior) {
            btn_Fighter.doClick();
        } else if (tempCharacter instanceof Wizard) {
            btn_wizard.doClick();
        } else {
            btn_thief.doClick();
        }
    }

    private void createUIComponents() {
        characterPanel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/Background_Character_3.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }

    public JPanel getCharacterPanel() {
        return characterPanel;
    }
}
