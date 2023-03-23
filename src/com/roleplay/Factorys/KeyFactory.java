package com.roleplay.Factorys;

import com.roleplay.characters.Character;
import com.roleplay.characters.enums.Directions;
import com.roleplay.gui.BoardPanel;
import com.roleplay.gui.GameFrame;
import com.roleplay.gui.MainFrame;
import com.roleplay.interfaces.IObserver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyFactory {

    private JComponent jc;
    private ArrayList<IObserver> observers =  new ArrayList<>();

    public void addKeyBindings(GameFrame component) {
        this.jc = component.getBoard();
        addObserver(component);

        setKeyActions("inventory", KeyEvent.VK_E);
        setKeyActions("move", KeyEvent.VK_UP);
        setKeyActions("changeDirectionForwards", KeyEvent.VK_RIGHT);
        setKeyActions("changeDirectionBackwards", KeyEvent.VK_LEFT);
    }

    private void setKeyActions(String keyName, int key) {
        this.jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0, false), keyName);
        this.jc.getActionMap().put(keyName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyName.equalsIgnoreCase("inventory")) {
                    if (jc instanceof BoardPanel)
                        ((BoardPanel) jc).setInventoryVisible();
                } else if (keyName.equalsIgnoreCase("move")) {
                    for (Character c : MainFrame.getCharacterList()) {
                        Directions playerDirection = c.getProperties().getDirection();
                        if (c.getProperties().isMyTurn()) {
                                if(playerDirection.equals(Directions.NORTH)){
                                    if(c.getProperties().getPosition().y > 0) {
                                        if (!((BoardPanel) jc).getGameMap().getMapElements()[c.getProperties().getPosition().y - 1][c.getProperties().getPosition().x].getMapElementProperties().getHitBox().isEnabled()) {
                                            c.getProperties().getPosition().translate(0, -1);
                                        }
                                    }
                                } else if(playerDirection.equals(Directions.EAST)){
                                    if(c.getProperties().getPosition().x < 40) {
                                        if (!((BoardPanel) jc).getGameMap().getMapElements()[c.getProperties().getPosition().y][c.getProperties().getPosition().x + 1].getMapElementProperties().getHitBox().isEnabled()) {
                                            c.getProperties().getPosition().translate(1, 0);
                                        }
                                    }
                                } else if(playerDirection.equals(Directions.SOUTH)){
                                    if(c.getProperties().getPosition().y < 25 ) {
                                        if (!((BoardPanel) jc).getGameMap().getMapElements()[c.getProperties().getPosition().y + 1][c.getProperties().getPosition().x].getMapElementProperties().getHitBox().isEnabled()) {
                                            c.getProperties().getPosition().translate(0, 1);
                                        }
                                    }
                                } else if(playerDirection.equals(Directions.WEST)) {
                                    if(c.getProperties().getPosition().x > 0) {
                                        if (!((BoardPanel) jc).getGameMap().getMapElements()[c.getProperties().getPosition().y][c.getProperties().getPosition().x - 1].getMapElementProperties().getHitBox().isEnabled()) {
                                            c.getProperties().getPosition().translate(-1, 0);
                                        }
                                    }
                                }
                        }
                    }
                } else if (keyName.equalsIgnoreCase("changeDirectionForwards")) {
                    for (Character c : MainFrame.getCharacterList()) {
                        Directions playerDirection = c.getProperties().getDirection();
                        if (c.getProperties().isMyTurn()) {
                            if(playerDirection.equals(Directions.NORTH)){
                                c.getProperties().setDirection(Directions.EAST);
                            } else if (playerDirection.equals(Directions.EAST)){
                                c.getProperties().setDirection(Directions.SOUTH);
                            } else if (playerDirection.equals(Directions.SOUTH)){
                                c.getProperties().setDirection(Directions.WEST);
                            } else if (playerDirection.equals(Directions.WEST)){
                                c.getProperties().setDirection(Directions.NORTH);
                            }
                        }
                    }
                } else if (keyName.equalsIgnoreCase("changeDirectionBackwards")) {
                    for (Character c : MainFrame.getCharacterList()) {
                        Directions playerDirection = c.getProperties().getDirection();
                        if (c.getProperties().isMyTurn()) {
                            if(playerDirection.equals(Directions.NORTH)){
                                c.getProperties().setDirection(Directions.WEST);
                            } else if (playerDirection.equals(Directions.WEST)){
                                c.getProperties().setDirection(Directions.SOUTH);
                            } else if (playerDirection.equals(Directions.SOUTH)){
                                c.getProperties().setDirection(Directions.EAST);
                            } else if (playerDirection.equals(Directions.EAST)){
                                c.getProperties().setDirection(Directions.NORTH);
                            }
                        }
                    }
                }
            }
        });
    }

    private void addObserver(IObserver observer){
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    private void notifyObservers(){
        for(IObserver o : observers){
            o.update();
        }
    }

}
