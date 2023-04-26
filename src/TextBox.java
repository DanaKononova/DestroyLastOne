import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextBox extends GameFigure implements Serializable {
    private String text;

    public TextBox(int startX, int startY, int endX, int endY, int X, int Y, int colorR, int colorG, int colorB, int drawAmount, Boolean isStatic, int dx, int dy) {
        super(startX, startY, endX, endY, X, Y, colorR, colorG, colorB, drawAmount, isStatic, dx, dy);
    }

    public void drawText(){

    }

    @Override
    boolean figureMove() {
        return false;
    }

    @Override
    void draw(Graphics2D g2d) {

    }

    @Override
    public void serializeToTextFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(startX + "," + startY + "," + endX + "," + endY + "," + X + "," + Y + "," +colorR + "," + colorG + "," + colorB + "," + drawAmount + "," + dx + "," + dy + ","+ text);
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
        text = parts[12];
    }
}