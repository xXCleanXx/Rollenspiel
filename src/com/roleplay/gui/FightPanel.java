package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.characters.Monster;
import com.roleplay.items.weapons.Weapon;
import com.roleplay.map.GameMap;
import com.roleplay.tools.ImageUtils;
import com.roleplay.tools.Messages;

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
    private boolean blockButton;
    private final GameMap gameMap;

    private static boolean isRunning = false;

    public FightPanel(GameMap gameMap) {
        setOpaque(false);
        setVisible(false);
        add(fightPanel);

        this.gameMap = gameMap;

        btn_fight.addActionListener(e -> {
            if (blockButton) return;

            blockButton = true;

            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    attack(fighter, opponent);
                    lbl_health2.setText(Messages.getString("live") + ": " + opponent.getProperties().getHealthPoints());

                    Thread.sleep(2000);

                    if(!gameMap.getSettings().getPlayers().contains(opponent) && !gameMap.getMonsters().contains(opponent)){
                        Thread.currentThread().interrupt();
                        setVisible(false);
                        return;
                    }

                    lbl_info.setText(opponent.getProperties().getDisplayName() + Messages.getString("greift") + fighter.getProperties().getDisplayName() + Messages.getString("an"));

                    Thread.sleep(2000);
                    attack(opponent, fighter);
                    lbl_health1.setText(Messages.getString("live") + ": " + fighter.getProperties().getHealthPoints());

                    Thread.sleep(2000);
                    lbl_info.setText(Messages.getString("fight_end"));

                    Thread.sleep(2000);

                    blockButton = false;
                    setVisible(false);
                    setRunning(false);
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

        if(opponent.getProperties().getHealthPoints() <= 0){
            lbl_info.setText(opponent.getProperties().getDisplayName() + " erliegt seinen Verletzungen");

            if(opponent instanceof Monster) {
                gameMap.removeMonster((Monster) opponent);
            } else {
                gameMap.getSettings().removePlayer(opponent);
            }

        } else{
            lbl_info.setText(opponent.getProperties().getDisplayName() + Messages.getString("erleidet") + diff + Messages.getString("damage"));
        }
        PlayerListPanel.update(opponent);
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
                g.drawImage(ImageUtils.loadImage("com/roleplay/resources/images/backgrounds/Fight.png"), 0, 0, this);
                Toolkit.getDefaultToolkit().sync();
            }
        };
    }

    public void setRunning(boolean running){
        isRunning = running;
    }

    public static boolean isRunning(){
        return isRunning;
    }
}
