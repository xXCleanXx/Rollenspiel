package com.roleplay.gui;

import com.roleplay.build.Chest;
import com.roleplay.map.Settings;
import com.roleplay.tools.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Random;

public class ControlPanel extends JPanel {
    public JButton button;
    private int value;
    public final JLabel showValue = new JLabel();
    public final JLabel mortalCount = new JLabel();
    public int turnCount = 0;
    private final Settings settings;

    public ControlPanel(Settings settings) {
        this.settings = settings;
        setLayout(new GridLayout(4, 1, 50, -300));
        setPreferredSize(new Dimension(190, BoardPanel.HEIGHT));
        button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("src/com/roleplay/resources/images/buttons/dice.png"))));
        button.addActionListener(e -> {
            Random rand = new Random();
            value = rand.nextInt(20) + 1;
            repaint();

            settings.getPlayers().get(turnCount).getProperties().setMyTurn(true);
            turnCount++;

            button.setEnabled(false);
        });

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        showValue.setHorizontalAlignment(JLabel.CENTER);
        showValue.setForeground(Color.green);

        mortalCount.setHorizontalAlignment(JLabel.CENTER);
        mortalCount.setForeground(Color.green);
        mortalCount.setText("Items: " + "0");

        add(button, 0);
        add(showValue, 1);
        add(mortalCount, 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageUtils.loadImage("src/com/roleplay/resources/images/backgrounds/controlBackGround.png"), 0, 0, this);
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
        mortalCount.setText("Items: " + Chest.getLength());
        if (getValue() == 0) {
            for (int i = 0; i < settings.getPlayers().size(); i++) {
                if (settings.getPlayers().get(i).getProperties().isMyTurn()) {
                    settings.getPlayers().get(i).getProperties().setMyTurn(false);
                    if (turnCount >= settings.getPlayers().size()) {
                        turnCount = 0;
                    }

                    break;
                }
            }
            /*try {
                while (!FightPanel.isRunning()) {
                    //Thread.sleep(1000);
                }
            } catch(InterruptedException ex){
                ex.printStackTrace();
            }*/


            ImageBackgroundPane jOption = new ImageBackgroundPane(ImageUtils.loadImage("src/com/roleplay/resources/images/backgrounds/background_info.png"));
            jOption.showMessageDialog(null, "Player " + (turnCount + 1) + "! \n it's your turn!");

            button.setEnabled(true);
        }

    }

    class ImageBackgroundPane extends JOptionPane {
        private BufferedImage img;

        public ImageBackgroundPane(BufferedImage image) {
            this.img = image;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension curSize = this.getSize();
            g.drawImage(img, 0, 0, curSize.width, curSize.height, null);
            Toolkit.getDefaultToolkit().sync();
        }

    }
}
