package com.roleplay.gui;

import com.roleplay.characters.Character;
import com.roleplay.interfaces.IObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ControlPanel extends JPanel {

    public JButton button;
    private int value;
    public final JLabel showValue = new JLabel();
    public int turnCount = 0;

    public ControlPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension(190, BoardPanel.HEIGHT));
        button = new JButton("roll");
        button.addActionListener(e -> {
            Random rand = new Random();
            value = rand.nextInt(20) + 1;
            repaint();

            MainFrame.getCharacterList().get(turnCount).getProperties().setMyTurn(true);
            turnCount++;
            if(turnCount == MainFrame.getCharacterList().size()){
                turnCount = 1;
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
            for (int i = 0; i < MainFrame.getCharacterList().size(); i++) {
                if (MainFrame.getCharacterList().get(i).getProperties().isMyTurn()) {
                    MainFrame.getCharacterList().get(i).getProperties().setMyTurn(false);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Player "+ turnCount + "! \n it's your turn!");
            button.setEnabled(true);
        }

    }
}
