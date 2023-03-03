package com.roleplay.gui;

import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.util.ArrayList;

public class InGamePlayersPanel extends JPanel {

    public InGamePlayersPanel(ArrayList<Character> players){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(50, 32*25));

        playerPanel infos;
        for(Character c : players){
            infos = new playerPanel(c.getProperties().getName(), ((CharacterProperties) c.getProperties()).getDisplayName(), ((CharacterProperties) c.getProperties()).getHealthPoints(), ((CharacterProperties) c.getProperties()).getHealthPoints());
            infos.setBorder(new BasicBorders.MarginBorder());
            add(infos);
        }

    }

    private class playerPanel extends JPanel{

        JLabel name = new JLabel();
        JLabel displayName = new JLabel();
        JLabel health = new JLabel();

        public playerPanel (String name, String displayName, double health, double maxHealth){

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            this.displayName.setText(displayName);
            this.name.setText(name);
            this.health.setText(health + " / " + maxHealth);

            add(this.displayName);
            add(this.name);
            add(this.health);
        }

    }

}
