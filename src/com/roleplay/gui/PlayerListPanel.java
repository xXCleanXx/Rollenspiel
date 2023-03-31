package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.map.Settings;
import com.roleplay.tools.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerListPanel extends JPanel {

    private final static List<PlayerPanel> pp = new ArrayList<>();

    public PlayerListPanel(Settings settings) {
        setLayout(new GridLayout(settings.getPlayers().size(),1,15,-80));
        setPreferredSize(new Dimension(190, BoardPanel.HEIGHT));

        this.setBorder(BorderFactory.createEmptyBorder(60,20,75,20));

        for(Character c : settings.getPlayers()){
            PlayerPanel pp = new PlayerPanel(c);

            Box box = new Box(BoxLayout.LINE_AXIS);
            box.add(Box.createHorizontalGlue());
            box.add(pp);
            box.add(Box.createHorizontalGlue());
            add(box);

            PlayerListPanel.pp.add(pp);
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/playerList.png"),0,0,this);
        Toolkit.getDefaultToolkit().sync();
    }

    public static void update(Character c) {
        for(PlayerPanel pp : pp){
            if(pp.subject.equals(c)){
                pp.health.setText(String.valueOf(c.getProperties().getHealthPoints()));
            }

        }
    }

    private static class PlayerPanel extends JPanel{
        protected JLabel displayName;
        protected JLabel type;
        protected JLabel health;
        protected Character subject;

        public PlayerPanel(Character c) {
            setLayout(new FlowLayout());
            setOpaque(false);
            this.displayName = new JLabel(c.getProperties().getDisplayName());
            this.type = new JLabel(c.getProperties().getName());
            this.health = new JLabel(String.valueOf(c.getProperties().getHealthPoints()));
            this.health.setForeground(Color.GREEN);
            this.subject = c;

            JLabel texture = new JLabel(new ImageIcon(c.getProperties().getTexture32()));
            displayName.setForeground(new Color(240, 240, 240));

            JPanel info = new JPanel();
            info.setOpaque(false);
            info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
            info.add(this.displayName);
            info.add(this.health);

            add(texture);
            add(info);
        }
    }
}