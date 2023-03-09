package com.roleplay.gui;

import com.roleplay.tiles.characters.Character;
import com.roleplay.tiles.properties.CharacterProperties;
import com.roleplay.tools.Image;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InGamePlayersPanel extends JPanel {

    public InGamePlayersPanel(ArrayList<Character> players){
        setLayout(new GridLayout(1,players.size(),10,0));
        setPreferredSize(new Dimension(GameBoard.WIDTH, 60));

        for(Character c : players){
            add(new playerPanel(c));

        }
    }

    private class playerPanel extends JPanel{

        protected JLabel name = new JLabel();
        protected JLabel displayName = new JLabel();
        protected JLabel health = new JLabel();
        JLabel texture;
        JPanel info = new JPanel();

        public playerPanel (Character c) {
            setLayout(new FlowLayout());
            this.displayName.setText(((CharacterProperties) c.getProperties()).getDisplayName());
            this.name.setText(c.getProperties().getName());
            this.health.setText(((CharacterProperties) c.getProperties()).getHealthPoints() + " / " + ((CharacterProperties) c.getProperties()).getMaxHealthPoints());

            texture = new JLabel(new ImageIcon(c.getProperties().getTexture()));
            info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
            info.add(this.displayName);
            info.add(this.name);
            info.add(this.health);

            add(texture);
            add(info);
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(Image.loadImage("src/com/roleplay/resources/images/buttons/btn_1.png"),0,0,this);
            Toolkit.getDefaultToolkit().sync();
        }
    }

}
