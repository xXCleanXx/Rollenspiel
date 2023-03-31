package com.roleplay.gui;

import com.roleplay.build.Chest;
import com.roleplay.characters.Monster;
import com.roleplay.characters.enums.Directions;
import com.roleplay.map.GameMap;
import com.roleplay.map.Settings;
import com.roleplay.map.Tile;
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
    private final GameMap gameMap;

    public ControlPanel(GameMap gameMap) {
        this.gameMap = gameMap;
        setLayout(new GridLayout(4, 1, 50, -300));
        setPreferredSize(new Dimension(190, BoardPanel.HEIGHT));
        button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setIcon(new ImageIcon(Objects.requireNonNull(ImageUtils.loadImage("com/roleplay/resources/images/buttons/dice.png"))));
        button.addActionListener(e -> {
            Random rand = new Random();
            value = rand.nextInt(20) + 1;
            repaint();

            gameMap.getSettings().getPlayers().get(turnCount).getProperties().setMyTurn(true);
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
        g.drawImage(ImageUtils.loadImage("com/roleplay/resources/images/backgrounds/controlBackGround.png"), 0, 0, this);
        showValue.setText(String.valueOf(getValue()));
        Toolkit.getDefaultToolkit().sync();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int values) {
        value = values;
    }

    private boolean moveMonster(Monster monster, int dx, int dy) {
        Tile<?> mapElement = gameMap.getMapElements()[monster.getProperties().getPosition().y + dy][monster.getProperties().getPosition().x + dx];

        if (!mapElement.getMapElementProperties().getHitBox().isEnabled()) {
            monster.getProperties().getPosition().translate(dx, dy);

            return true;
        }

        return false;
    }

    private void moveMonster() {
        if (gameMap.getMonsters().size() > 0) {
            Random random = new Random();
            Monster monster = gameMap.getMonsters().get(random.nextInt(0, gameMap.getMonsters().size()));
            monster.changeDirection(Directions.values()[random.nextInt(0, 4)]);

            boolean canMove = true;

            do {
                if (monster.getProperties().getDirection() == Directions.NORTH && monster.getProperties().getPosition().y > 0) {
                    canMove = !moveMonster(monster, 0, -1);
                } else if (monster.getProperties().getDirection() == Directions.EAST && monster.getProperties().getPosition().x < 40) {
                    canMove = !moveMonster(monster, 1, 0);
                } else if (monster.getProperties().getDirection() == Directions.SOUTH && monster.getProperties().getPosition().y < 25) {
                    canMove = !moveMonster(monster, 0, 1);
                } else if (monster.getProperties().getDirection() == Directions.WEST && monster.getProperties().getPosition().x > 0) {
                    canMove = !moveMonster(monster, -1, 0);
                }

                if (canMove) {
                    monster.changeDirection(Directions.values()[random.nextInt(0, 4)]);
                }
            } while (canMove);
        }
    }

    public void update() {
        setValue(this.getValue() - 1);
        showValue.setText(String.valueOf(value));
        mortalCount.setText("Items: " + Chest.getLength());
        mortalCount.setText(String.valueOf(Chest.getLength()));

        moveMonster();

        if (getValue() == 0) {
            for (int i = 0; i < gameMap.getSettings().getPlayers().size(); i++) {
                if (gameMap.getSettings().getPlayers().get(i).getProperties().isMyTurn()) {
                    gameMap.getSettings().getPlayers().get(i).getProperties().setMyTurn(false);
                    if (turnCount >= gameMap.getSettings().getPlayers().size()) {
                        turnCount = 0;
                    }

                    break;
                }
            }

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
