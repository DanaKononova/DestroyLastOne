import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameBonus extends GameFigure implements Serializable {
    private int amount;

    public GameBonus(int startX, int startY, int endX, int endY, int centerX, int centerY, int colorR, int colorG, int colorB, int drawAmount, Boolean isStatic, int dx, int dy) {
        super(startX, startY, endX, endY, centerX, centerY, colorR, colorG, colorB, drawAmount, isStatic, dx, dy);
    }

    GameBonus(){

    }
    @Override
    boolean figureMove() {
        return false;
    }

    @Override
    void draw(Graphics2D g2d) {

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void serializeToTextFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(startX + "," + startY + "," + endX + "," + endY + "," + X + "," + Y + "," + colorR + "," + colorG + "," + colorB + "," + drawAmount + "," + dx + "," + dy + "," + amount);
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
        dx = Integer.parseInt(parts[10]);
        dy = Integer.parseInt(parts[11]);
        amount = Integer.parseInt(parts[12]);
    }
}
