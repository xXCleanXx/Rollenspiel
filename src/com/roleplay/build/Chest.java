package com.roleplay.build;

import com.roleplay.gui.BoardPanel;
import com.roleplay.items.MortalInstruments;
import com.roleplay.map.GameMapElementProperties;
import com.roleplay.map.Tile;

import java.util.ArrayList;
import java.util.List;

public class Chest extends Tile<GameMapElementProperties> {
    static List<MortalInstruments> list = new ArrayList<>();

    public Chest(GameMapElementProperties tileProperties) {
        super(tileProperties);
        getProperties().getHitBox().setEnabled(false);
    }

    public void addInstrument(MortalInstruments instruments) {
        list.add(instruments);
        if (list.size() == 3) {
            BoardPanel.setInfoVisible();
        }
    }

    public static int getLength(){
        return list.size();
    }

}