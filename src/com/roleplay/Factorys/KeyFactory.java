package com.roleplay.Factorys;

import com.roleplay.characters.Character;
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
                        if (c.getProperties().isMyTurn()) {

                        }
                    }

                }
                notifyObservers();
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
