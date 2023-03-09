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
        protected JLabel displayName;
        protected JLabel type;
        protected JLabel nameAndType;
        protected JLabel health;

        JLabel texture;
        JPanel info = new JPanel();

        public playerPanel (Character c) {
            setLayout(new FlowLayout());
            this.displayName = new JLabel(c.getProperties().getDisplayName());
            this.type = new JLabel(c.getProperties().getName());
            this.health = new JLabel(String.valueOf(c.getProperties().getHealthPoints()));

            texture = new JLabel(new ImageIcon(c.getProperties().getTexture()));
            nameAndType = new JLabel(this.displayName.getText() + "/" + this.type.getText());

            info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
            info.add(nameAndType);
            info.add(this.health);
            info.setOpaque(false);

            add(texture);
            add(info);
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(Image.loadImage("src/com/roleplay/resources/images/buttons/btn_1.png"),(getWidth()/2) - 79,(getHeight()/2) - 30,this);
            Toolkit.getDefaultToolkit().sync();
        }
    }

}
