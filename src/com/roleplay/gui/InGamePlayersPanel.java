package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.tools.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InGamePlayersPanel extends JPanel {

    public InGamePlayersPanel(ArrayList<Character> players){
        setLayout(new GridLayout(players.size(),1,15,-100));
        setPreferredSize(new Dimension(158, GameBoard.HEIGHT));

        this.setBorder(BorderFactory.createEmptyBorder(60,10,75,25));


        for(Character c : players){
            add(new PlayerPanel(c));

        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/playerList.png"),0,0,this);
        Toolkit.getDefaultToolkit().sync();
    }

    private static class PlayerPanel extends JPanel{
        protected JLabel displayName;
        protected JLabel type;
        protected JLabel nameAndType;
        protected JLabel health;

        JLabel texture;
        JPanel info = new JPanel();

        public PlayerPanel(Character c) {
            setLayout(new FlowLayout());
            setOpaque(false);
            this.displayName = new JLabel(c.getProperties().getDisplayName());
            this.type = new JLabel(c.getProperties().getName());
            this.health = new JLabel(String.valueOf(c.getProperties().getHealthPoints()));

            texture = new JLabel(new ImageIcon(c.getProperties().getTexture()));
            nameAndType = new JLabel(this.displayName.getText() + "/" + this.type.getText());

            info.setOpaque(false);
            info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
            info.add(nameAndType);
            info.add(this.health);

            add(texture);
            add(info);
            setBorder(BorderFactory.createLineBorder(Color.RED));
        }
    }

}
