package com.roleplay.Factories;

import com.roleplay.build.Door;
import com.roleplay.characters.Character;
import com.roleplay.characters.enums.Directions;
import com.roleplay.gui.BoardPanel;
import com.roleplay.gui.GameFrame;
import com.roleplay.interfaces.IObserver;
import com.roleplay.items.Item;
import com.roleplay.map.Settings;

import javax.management.InstanceNotFoundException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class KeyFactory {
    private BoardPanel jc;
    private final List<IObserver> observers = new ArrayList<>();
    private final Settings settings;

    public KeyFactory(Settings settings) {
        this.settings = settings;
    }

    public void addKeyBindings(GameFrame component) {
        this.jc = component.getBoard();
        addObserver(component);

        setKeyActions("inventory", KeyEvent.VK_E);
        setKeyActions("move", KeyEvent.VK_ENTER);
        setKeyActions("DirectionEast", KeyEvent.VK_RIGHT);
        setKeyActions("DirectionWest", KeyEvent.VK_LEFT);
        setKeyActions("DirectionNorth", KeyEvent.VK_UP);
        setKeyActions("DirectionSouth", KeyEvent.VK_DOWN);
    }

    private void setKeyActions(String keyName, int key) {
        this.jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0, false), keyName);
        this.jc.getActionMap().put(keyName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyName.equalsIgnoreCase("inventory")) {
                    jc.setInventoryVisible();
                } else if (keyName.equalsIgnoreCase("move")) {
                    for (Character c : settings.getPlayers()) {
                        Directions playerDirection = c.getProperties().getDirection();

                        if (c.getProperties().isMyTurn()) {
                            if (playerDirection.equals(Directions.NORTH)) {
                                if (c.getProperties().getPosition().y > 0) {
                                    performPlayerMove(c, 0, -1);
                                }
                            } else if (playerDirection.equals(Directions.EAST)) {
                                if (c.getProperties().getPosition().x < 40) {
                                    performPlayerMove(c, 1, 0);
                                }
                            } else if (playerDirection.equals(Directions.SOUTH)) {
                                if (c.getProperties().getPosition().y < 25) {
                                    performPlayerMove(c, 0, 1);
                                }
                            } else if (playerDirection.equals(Directions.WEST)) {
                                if (c.getProperties().getPosition().x > 0) {
                                    performPlayerMove(c, -1, 0);
                                }
                            }
                        }
                    }
                } else if (keyName.equalsIgnoreCase("DirectionNorth")) {
                    for (Character c : settings.getPlayers()) {
                        if (c.getProperties().isMyTurn()) {
                            c.changeDirection(Directions.NORTH);
                        }
                    }
                } else if (keyName.equalsIgnoreCase("DirectionEast")) {
                    for (Character c : settings.getPlayers()) {
                        if (c.getProperties().isMyTurn()) {
                            c.changeDirection(Directions.EAST);
                        }
                    }
                } else if (keyName.equalsIgnoreCase("DirectionSouth")) {
                    for (Character c : settings.getPlayers()) {
                        if (c.getProperties().isMyTurn()) {
                            c.changeDirection(Directions.SOUTH);
                        }
                    }
                } else if (keyName.equalsIgnoreCase("DirectionWest")) {
                    for (Character c : settings.getPlayers()) {
                        if (c.getProperties().isMyTurn()) {
                            c.changeDirection(Directions.WEST);
                        }
                    }
                }
            }
        });
    }

    private void addObserver(IObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    private void performPlayerMove(Character c, int dx, int dy) {
        if (!jc.getGameMap().getMapElements()[c.getProperties().getPosition().y + dy][c.getProperties().getPosition().x + dx].getMapElementProperties().getHitBox().isEnabled()) {
            c.getProperties().getPosition().translate(dx, dy);

            for (Item item : jc.getItems()) {
                if (item.getProperties().getPosition().getX() == (c.getProperties().getPosition()).getX() && item.getProperties().getPosition().getY() == (c.getProperties().getPosition()).getY()) {
                    c.collectItem(item);
                    jc.getItems().remove(item);

                    break;
                }
            }
            notifyObservers();
        } else if ((jc.getGameMap().getMapElements()[c.getProperties().getPosition().y + dy][c.getProperties().getPosition().x + dx] instanceof Door && c.getProperties().getInventory().containsItem("key"))) {
            ((Door) jc.getGameMap().getMapElements()[c.getProperties().getPosition().y + dy][c.getProperties().getPosition().x + dx]).open();
            try {
                c.getProperties().getInventory().remove(c.getProperties().getInventory().getItemIndexByName("key"));
                c.getProperties().getPosition().translate(dx, dy);
            } catch (InstanceNotFoundException e) {
                e.printStackTrace();
            }
            notifyObservers();
        }

    }

    private void notifyObservers() {
        for (IObserver o : observers) {
            o.update();
        }
    }
}