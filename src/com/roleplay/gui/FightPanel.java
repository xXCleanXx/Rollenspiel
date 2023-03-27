package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.items.weapons.Weapon;
import com.roleplay.tools.ImageUtils;
import com.roleplay.tools.Messages;
import com.roleplay.interfaces.IObserver;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

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
                    lbl_health2.setText(Messages.getString("live") + ": " + opponent.getProperties().getHealthPoints());

                    Thread.sleep(2000);

                    lbl_info.setText(opponent.getProperties().getDisplayName() + Messages.getString("greift") + fighter.getProperties().getDisplayName() + Messages.getString("an"));

                    Thread.sleep(2000);

                    attack(opponent, fighter);
                    lbl_health1.setText(Messages.getString("live") + ": " + fighter.getProperties().getHealthPoints());

                    Thread.sleep(1000);

                    lbl_info.setText(Messages.getString("fight_end"));

                    Thread.sleep(1000);

                    setVisible(false);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }).start();
        });
    }

    private void attack(Character fighter, Character opponent) {
        final double defence = Objects.requireNonNull(opponent).defend();
        double diff = 1 - defence;
        if (Objects.requireNonNull(fighter).getProperties().getInventory().getFirstHand() instanceof Weapon weapon) {
            if (defence < weapon.getDamage()) {
                diff = weapon.getDamage() - defence;
            }
        }
        if (diff < 0) {
            diff = 0;
        }
        opponent.getProperties().setHealthPoints(opponent.getProperties().getHealthPoints() - diff);
        lbl_info.setText(opponent.getProperties().getDisplayName() + Messages.getString("erleidet") + diff + Messages.getString("damage"));
    }

    public void initialize(Character fighter, Character opponent) {
        this.fighter = fighter;
        this.opponent = opponent;
        lbl_name1.setText(fighter.getProperties().getDisplayName());
        lbl_health1.setText(Messages.getString("live") + ": " + fighter.getProperties().getHealthPoints());
        lbl_texture1.setIcon(new ImageIcon(fighter.getProperties().getTexture300()));

        lbl_name2.setText(opponent.getProperties().getDisplayName());
        lbl_health2.setText(Messages.getString("live") + ": " + opponent.getProperties().getHealthPoints());
        lbl_texture2.setIcon(new ImageIcon(opponent.getProperties().getTexture300()));

        lbl_info.setText(fighter.getProperties().getDisplayName() + Messages.getString("greift") + opponent.getProperties().getDisplayName() + Messages.getString("an"));
    }

    private void createUIComponents() {
        fightPanel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/backgrounds/Fight.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }
}
