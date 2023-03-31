package com.roleplay.tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class ImageUtils {

    public static BufferedImage loadImage(String pathname) {
        BufferedImage img = null;

        if (pathname.isEmpty()) {
            return null;
        } else {
            try {
                InputStream is = ImageUtils.class.getClassLoader().getResourceAsStream(pathname);
                img = ImageIO.read(is);
                is.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return img;
    }
}
