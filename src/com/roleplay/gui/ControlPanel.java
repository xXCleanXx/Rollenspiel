package com.roleplay.gui;

import com.roleplay.characters.Character;
import interfaces.IObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ControlPanel extends JPanel implements IObserver {

    public static JButton button;
    private static int value;
    public static final JLabel showValue = new JLabel();

    public static ArrayList<Character> leftInRound;

    public ControlPanel(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension(190, BoardPanel.HEIGHT));
        button = new JButton("roll");
        button.addActionListener(e -> {
            Random rand = new Random();
            value = rand.nextInt(20) + 1;
            repaint();

            if(leftInRound == null || leftInRound.isEmpty())
                leftInRound = new ArrayList<>(MainFrame.getCharacterList());

            leftInRound.get(0).getProperties().setMyTurn(true);
            button.setEnabled(false);
        });

        add(showValue);
        add(button);

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        showValue.setText(String.valueOf(getValue()));
        Toolkit.getDefaultToolkit().sync();
    }

    public static int getValue(){
        return value;
    }

    public static void setValue(int values){
        value = values;
    }

    @Override
    public void update() {

    }
}
