package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.items.weapons.Weapon;

import javax.swing.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FightPanel extends JPanel {
    private JPanel fightPanel;
    private JLabel lbl_name1;
    private JLabel lbl_name2;
    private JLabel lbl_health1;
    private JLabel lbl_health2;
    private JLabel lbl_info;
    private JLabel lbl_texture1;
    private JLabel lbl_texture2;
    private JButton btn_fight;
    private Character fighter;
    private Character opponent;

    public FightPanel() {
        setOpaque(false);
        setVisible(false);
        add(fightPanel);

        btn_fight.addActionListener(e -> {
            new Thread(() -> {
                try {
                    attack(fighter, opponent);
                    lbl_health2.setText("" + opponent.getProperties().getHealthPoints());

                    Thread.sleep(2000);

                    lbl_info.setText(fighter.getProperties().getDisplayName() + " greift " + opponent.getProperties().getDisplayName() + " an.");

                    Thread.sleep(2000);

                    attack(opponent, fighter);
                    lbl_health1.setText("" + fighter.getProperties().getHealthPoints());
                    repaint();

                    Thread.sleep(2000);

                    lbl_info.setText("Kampf beendet");
                    repaint();
                    setVisible(false);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }).start();
        });
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

    public void initialize(Character fighter, Character opponent) {
        this.fighter = fighter;
        this.opponent = opponent;
        lbl_name1.setText(fighter.getProperties().getDisplayName());
        lbl_health1.setText("" + fighter.getProperties().getHealthPoints());
        lbl_texture1.setIcon(new ImageIcon(fighter.getProperties().getTexture300()));

        lbl_name2.setText(opponent.getProperties().getDisplayName());
        lbl_health2.setText("" + opponent.getProperties().getHealthPoints());
        lbl_texture2.setIcon(new ImageIcon(opponent.getProperties().getTexture300()));

        lbl_info.setText(fighter.getProperties().getDisplayName() + " greift " + opponent.getProperties().getDisplayName() + " an.");

    }

}
