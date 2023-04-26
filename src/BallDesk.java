import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import static java.lang.Math.abs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BallDesk extends GameFigure implements Serializable {
    KeyEvent key;

    public BallDesk(int startX, int startY, int endX, int endY, int centerX, int centerY, int colorR, int colorG, int colorB, int drawAmount, boolean isStatic, int dx, int dy) {
        super(startX, startY, endX, endY, centerX, centerY, colorR, colorG, colorB, drawAmount, isStatic, dx, dy);
    }

    BallDesk(){

    }

    @Override
    boolean figureMove() {
        if (key != null) {
            int keyCode = key.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT) {
                startX = (startX - drawAmount);
                endX = (endX - drawAmount);
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                startX = (startX + drawAmount);
                endX = (endX + drawAmount);
            }
            if (startX < 0) {
                endX = (endX - startX);
                startX = 0;
            } else if (endX > 1000) {
                startX = (1000 - (endX - startX));
                endX = 1000;
            }
        }
        return true;
    }

    @Override
    void draw(Graphics2D g2d) {
        float[] color = new float[3];
        Color.RGBtoHSB(colorR, colorG, colorB, color);
        g2d.setColor(Color.getHSBColor(color[0], color[1], color[2]));
        Rectangle rect = new Rectangle(startX, startY, abs(startX - endX), abs(startY - endY));
        g2d.fill(rect);
        g2d.draw(rect);
    }

    @Override
    public void serializeToTextFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(startX + "," + startY + "," + endX + "," + endY + "," + X + "," + Y + "," + colorR + "," + colorG + "," + colorB + "," + drawAmount + ","+ isStatic+ "," + dx + "," + dy );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deserializeFromTextFile(String content) {
        String[] parts = content.split(",");
        startX = (Integer.parseInt(parts[0]));
        startY = (Integer.parseInt(parts[1]));
        endX = (Integer.parseInt(parts[2]));
        endY = (Integer.parseInt(parts[3]));
        X = (Integer.parseInt(parts[4]));
        Y = (Integer.parseInt(parts[5]));
        colorR = Integer.parseInt(parts[6]);
        colorG = Integer.parseInt(parts[7]);
        colorB = Integer.parseInt(parts[8]);
        drawAmount = Integer.parseInt(parts[9]);
        isStatic = Boolean.parseBoolean(parts[10]);
        dx = Integer.parseInt(parts[11]);
        dy = Integer.parseInt(parts[12]);
    }
}
