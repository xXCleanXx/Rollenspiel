package com.roleplay.enviroment;

import com.roleplay.characters.Character;
import com.roleplay.gui.BoardPanel;

import java.awt.*;

public class EnviromentManager {

    BoardPanel bp;
    Lighting lighting;

    public EnviromentManager(BoardPanel bp){
        this.bp=bp;
    }

    public void setup(Character character){
        lighting = new Lighting(bp,350, character);
    }

    public void draw(Graphics2D g2){
        lighting.draw(g2);
    }

}
