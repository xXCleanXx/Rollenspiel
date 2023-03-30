package com.roleplay.enviroment;

import com.roleplay.characters.Character;
import com.roleplay.gui.BoardPanel;
import com.roleplay.map.GameMap;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Lighting {

    private BufferedImage darknessFilter;

    public Lighting(BoardPanel bp, int circleSize, Character character) {

        // Create a buffered image
        darknessFilter = new BufferedImage(GameMap.TILE_SIZE * 43, GameMap.TILE_SIZE * 25, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) darknessFilter.getGraphics();

        Area screenArea = new Area(new Rectangle2D.Double(0, 0, GameMap.TILE_SIZE * 43, GameMap.TILE_SIZE * 25));

        // Get the center x and y of the light circle
        int centerX = character.getProperties().getPosition().x + (GameMap.TILE_SIZE) / 2;
        int centerY = character.getProperties().getPosition().y + (GameMap.TILE_SIZE) / 2;

        double x = centerX - (circleSize / 2);
        double y = centerY - (circleSize / 2);

        Shape circlShape = new Ellipse2D.Double(x, y, circleSize, circleSize);

        Area lightArea = new Area(circlShape);

        screenArea.subtract(lightArea);

        g2.setColor(new Color(0, 0, 0, 0.95f));

        g2.fill(screenArea);

        g2.dispose();
/*
        // Create a gradation effect
        Color color[] = new Color[12];
        float fraction[] = new float[12];

        color[0] = new Color(0,0,0,0.1f);
        color[1] = new Color(0,0,0,0.42f);
        color[2] = new Color(0,0,0,0.52f);
        color[3] = new Color(0,0,0,0.61f);
        color[4] = new Color(0,0,0,0.69f);
        color[5] = new Color(0,0,0,0.76f);
        color[6] = new Color(0,0,0,0.82f);
        color[7] = new Color(0,0,0,0.87f);
        color[8] = new Color(0,0,0,0.91f);
        color[9] = new Color(0,0,0,0.94f);
        color[10] = new Color(0,0,0,0.96f);
        color[11] = new Color(0,0,0,0.98f);

        fraction[0] = 0f;
        fraction[1] = 0.4f;
        fraction[2] = 0.5f;
        fraction[3] = 0.6f;
        fraction[4] = 0.65f;
        fraction[5] = 0.7f;
        fraction[6] = 0.75f;
        fraction[7] = 0.8f;
        fraction[8] = 0.85f;
        fraction[9] = 0.9f;
        fraction[10] = 0.95f;
        fraction[11] = 1f;

        // Create a gradation paint settings
        RadialGradientPaint gPaint = new RadialGradientPaint(centerX, centerY, (circleSize/2), fraction, color);

        // Set the gradient data on g2
        g2.setPaint(gPaint);

        g2.fillRect(0, 0, bp.getGameMap().getWidth(), bp.getGameMap().getHeight());
*/

    }

    public void draw(Graphics2D g2) {
        g2.drawImage(darknessFilter, 0, 0, null);
    }
}
