package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.interfaces.IObserver;
import com.roleplay.map.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ControlPanel extends JPanel {
    public JButton button;
    private int value;
    public final JLabel showValue = new JLabel();
    public int turnCount = 0;
    private final Settings settings;

    public ControlPanel(Settings settings) {
        this.settings = settings;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension(190, BoardPanel.HEIGHT));
        button = new JButton("roll");
        button.addActionListener(e -> {
            Random rand = new Random();
            value = rand.nextInt(20) + 1;
            repaint();

            settings.getPlayers().get(turnCount).getProperties().setMyTurn(true);
            turnCount++;

            if(turnCount == settings.getPlayers().size()){
                turnCount = 0;
            }

            button.setEnabled(false);
        });

        add(showValue);
        add(button);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        showValue.setText(String.valueOf(getValue()));
        Toolkit.getDefaultToolkit().sync();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int values) {
        value = values;
    }

    public void update() {
        setValue(this.getValue() - 1);
        showValue.setText(String.valueOf(value));
        if (getValue() == 0) {
            for (int i = 0; i < settings.getPlayers().size(); i++) {
                if (settings.getPlayers().get(i).getProperties().isMyTurn()) {
                    settings.getPlayers().get(i).getProperties().setMyTurn(false);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Player "+ (turnCount + 1) + "! \n it's your turn!");
            button.setEnabled(true);
        }

    }
}
