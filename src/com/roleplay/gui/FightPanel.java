package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.items.weapons.Weapon;
import com.roleplay.tools.ImageUtils;

import javax.swing.*;
import java.util.Objects;

public class FightPanel {
    private JPanel fightPanel;
    private JLabel lbl_name1;
    private JLabel lbl_name2;
    private JLabel lbl_health1;
    private JLabel lbl_health2;
    private JLabel lbl_info;
    private JLabel lbl_texture1;
    private JLabel lbl_texture2;

    public FightPanel(Character fighter, Character opponent) {
        lbl_name1.setText(fighter.getProperties().getDisplayName());
        lbl_health1.setText("" + fighter.getProperties().getHealthPoints());
        lbl_texture1.setIcon(new ImageIcon(fighter.getProperties().getTexture()));

        lbl_name2.setText(opponent.getProperties().getDisplayName());
        lbl_health2.setText("" + opponent.getProperties().getHealthPoints());
        lbl_texture2.setIcon(new ImageIcon(opponent.getProperties().getTexture()));

        lbl_info.setText(fighter.getProperties().getDisplayName() + " greift " + opponent.getProperties().getDisplayName() + " an.");
        attack(fighter, opponent);
        lbl_info.setText(fighter.getProperties().getDisplayName() + " greift " + opponent.getProperties().getDisplayName() + " an.");
        attack(opponent, fighter);
        lbl_info.setText("Kampf beendet");

    }

    private boolean attack(Character fighter, Character opponent) {
        if (Objects.requireNonNull(fighter).getProperties().getInventory().getFirstHand() instanceof Weapon weapon) {
            double defence = Objects.requireNonNull(opponent).defend();

            if (defence < weapon.getDamage()) {
                double diff = weapon.getDamage() - defence;

                opponent.getProperties().setHealthPoints(opponent.getProperties().getHealthPoints() - diff);
                lbl_info.setText(opponent.getProperties().getDisplayName() + " erleidet " + diff + " schaden.");

            }
        }
        return opponent.getProperties().getHealthPoints() > 0;
    }
}
