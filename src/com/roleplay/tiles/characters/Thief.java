package com.roleplay.tiles.characters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Thief extends Character {



    public Thief(CharacterBuilder characterBuilder, Point pos) {
        super(characterBuilder);
        setPosition(pos);
        try {
            setImg(ImageIO.read(new File("src/com/roleplay/resources/images/gras.png")));
        }catch (IOException ex){
            ex.printStackTrace();
        }
        }

    @Override
    public double attack(Character enemy) {
        return 0;
    }

    @Override
    public double defend() {
        return 0;
    }

    @Override
    public void levelUp() {

    }
}
