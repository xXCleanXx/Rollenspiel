package com.roleplay.tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageUtils {

    public static BufferedImage loadImage(String pathname) {
        BufferedImage img = null;

        if(pathname.isEmpty()){
            return null;
        } else {
            try {
                img = ImageIO.read(new File(pathname));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return img;
    }
}
