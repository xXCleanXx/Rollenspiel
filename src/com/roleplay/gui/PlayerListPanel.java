package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.tools.ImageUtils;
import interfaces.IObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerListPanel extends JPanel implements IObserver {

    public PlayerListPanel(ArrayList<Character> players){
        setLayout(new GridLayout(players.size(),1,15,-80));
        setPreferredSize(new Dimension(190, BoardPanel.HEIGHT));

        this.setBorder(BorderFactory.createEmptyBorder(60,20,75,20));


        for(Character c : players){
            Box box = new Box(BoxLayout.LINE_AXIS);
            box.add(Box.createHorizontalGlue());
            box.add(new PlayerPanel(c));
            box.add(Box.createHorizontalGlue());

            add(box);

        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/playerList.png"),0,0,this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void update() {

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
            this.health.setForeground(Color.GREEN);

            texture = new JLabel(new ImageIcon(c.getProperties().getTexture()));
            displayName.setForeground(new Color(240, 240, 240));

            info.setOpaque(false);
            info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
            info.add(this.displayName);
            info.add(this.health);

            add(texture);
            add(info);
        }
    }

}
