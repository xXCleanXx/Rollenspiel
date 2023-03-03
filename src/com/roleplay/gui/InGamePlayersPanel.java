package com.roleplay.gui;

import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class InGamePlayersPanel extends JPanel {

    public InGamePlayersPanel(ArrayList<Character> players){
        setLayout(new GridLayout(1,players.size(),10,0));
        setPreferredSize(new Dimension(GameBoard.WIDTH, 60));

        JPanel container = new JPanel(new FlowLayout());
        playerPanel infos;
        JLabel texture;

        for(Character c : players){
            infos = new playerPanel(c.getProperties().getName(), ((CharacterProperties) c.getProperties()).getDisplayName(), ((CharacterProperties) c.getProperties()).getHealthPoints(), ((CharacterProperties) c.getProperties()).getMaxHealthPoints());
            infos.setBorder(new BasicBorders.MarginBorder());

            texture = new JLabel(new ImageIcon(c.getProperties().getTexture()));

            container.add(texture);
            container.add(infos);
            add(container);

        }
    }

    private class playerPanel extends JPanel{

        protected JLabel name = new JLabel();
        protected JLabel displayName = new JLabel();
        protected JLabel health = new JLabel();

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
