import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import static java.lang.Math.abs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameBall extends GameFigure implements Serializable {

    public GameBall(int startX, int startY, int endX, int endY, int centerX, int centerY, int colorR, int colorG, int colorB, int drawAmount, Boolean isStatic, int dx, int dy) {
        super(startX, startY, endX, endY, centerX, centerY, colorR, colorG, colorB, drawAmount, isStatic, dx, dy);
    }
    GameBall(){

    }

    @Override
    boolean figureMove() {
        if (startY > 600) return false;
        if (endY < 0) dy = -dy;
        if (startX < 0 || endX > 1000) dx = -dx;
        startX = startX + dx;
        endX = endX + dx;
        startY = startY - dy;
        endY = endY - dy;
        if (dx != 0) dx = drawAmount * dx / abs(dx);
        if (dy != 0) dy = drawAmount * dy / abs(dy);
        return true;
    }

    @Override
    void draw(Graphics2D g2d) {
        float[] color = new float[3];
        Color.RGBtoHSB(colorR, colorG, colorB, color);
        g2d.setColor(Color.getHSBColor(color[0], color[1], color[2]));
        g2d.fillOval(startX-1, startY-1, abs(startX - endX-1), abs(startY - endY-1));
    }

    public void setSpeed(int speed) {
        drawAmount += 1;
    }

    @Override
    public void serializeToTextFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(startX + "," + startY + "," + endX + "," + endY + "," + X + "," + Y + "," + colorR + "," + colorG + "," + colorB + "," + drawAmount+ ","+ isStatic + "," + dx + "," + dy);
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
