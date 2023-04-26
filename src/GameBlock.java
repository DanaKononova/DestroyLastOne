import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import static java.lang.Math.abs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameBlock extends GameFigure implements Serializable {
  //  private GameBonus gameBonus;
    private Boolean isHitted = false;

    public GameBlock(int startX, int startY, int endX, int endY, int X, int Y, int colorR, int colorG, int colorB, int drawAmount, Boolean isStatic, int dx, int dy) {
        super(startX, startY, endX, endY, X, Y, colorR, colorG, colorB, drawAmount, isStatic, dx, dy);
    }

    GameBlock(){

    }


    @Override
    boolean figureMove() {
        return false;
    }

    @Override
    void draw(Graphics2D g2d) {
        if (!isHitted) {
            float[] color = new float[3];
            Color.RGBtoHSB(colorR, colorG, colorB, color);
            g2d.setColor(Color.getHSBColor(color[0], color[1], color[2]));
            Rectangle rect = new Rectangle(startX, startY, abs(startX - endX), abs(startY - endY));
            g2d.fill(rect);
            g2d.draw(rect);
        } else {
            startX = 0;
            endX = 0;
            startY = 0;
            endY = 0;
        }
    }

    public void setHitted(Boolean hitted) {
        isHitted = hitted;
    }

    @Override
    public void serializeToTextFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(getStartX() + "," + getStartY() + "," + getEndX() + "," + getEndY() + "," + getX() + "," + getY() + "," + colorR + "," + colorG + "," + colorB + "," + getDrawAmount()+ ","+ isStatic + "," + getDx() + "," + getDy() + "," + isHitted);
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
        isHitted = Boolean.parseBoolean(parts[13]);
    }
}
