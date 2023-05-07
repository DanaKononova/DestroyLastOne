import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Field;

import static java.lang.Math.abs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameBlock extends GameFigure implements Serializable {
    private Boolean isHitted = false;

    public GameBlock(int startX, int startY, int endX, int endY, int X, int Y, int color, int drawAmount, Boolean isStatic, int dx, int dy) {
        super(startX, startY, endX, endY, X, Y, color, drawAmount, isStatic, dx, dy);
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
            g2d.setColor(new Color(color));
            Rectangle rect = new Rectangle(getStartX(), startY, abs(getStartX() - endX), abs(startY - endY));
            g2d.fill(rect);
            g2d.setColor(Color.BLACK);
            g2d.draw(rect);
        } else {
            setStartX(0);
            endX = 0;
            startY = 0;
            endY = 0;
        }
    }

    public void setHitted(Boolean hitted) {
        isHitted = hitted;
    }

    @Override
    public Object createFieldObject() throws IllegalAccessException, NoSuchFieldException {
        Field field = this.getClass().getSuperclass().getDeclaredField("startX");
        field.setAccessible(true);
        field.set(this, this.getStartX());
        field = super.getClass().getSuperclass().getDeclaredField("startY");
        field.setAccessible(true);
        field.set(this, this.startY);
        field = this.getClass().getSuperclass().getDeclaredField("endX");
        field.setAccessible(true);
        field.set(this, this.endX);
        field = this.getClass().getSuperclass().getDeclaredField("endY");
        field.setAccessible(true);
        field.set(this, this.endY);
        field = this.getClass().getSuperclass().getDeclaredField("X");
        field.setAccessible(true);
        field.set(this, this.X);
        field = this.getClass().getSuperclass().getDeclaredField("Y");
        field.setAccessible(true);
        field.set(this, this.Y);
        field = this.getClass().getSuperclass().getDeclaredField("color");
        field.setAccessible(true);
        field.set(this, this.color);
        field = this.getClass().getSuperclass().getDeclaredField("drawAmount");
        field.setAccessible(true);
        field.set(this, this.drawAmount);
        field = this.getClass().getSuperclass().getDeclaredField("dx");
        field.setAccessible(true);
        field.set(this, this.dx);
        field = this.getClass().getSuperclass().getDeclaredField("dy");
        field.setAccessible(true);
        field.set(this, this.dy);
        field = this.getClass().getSuperclass().getDeclaredField("isStatic");
        field.setAccessible(true);
        field.set(this, this.isStatic);
        field = this.getClass().getDeclaredField("isHitted");
        field.setAccessible(true);
        field.set(this, this.isHitted);
        return this;
    }

    @Override
    public void serializeToTextFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(getStartX() + "," + getStartY() + "," + getEndX() + "," + getEndY() + "," + getX() + "," + getY() + "," + color + "," + getDrawAmount()+ ","+ isStatic + "," + getDx() + "," + getDy() + "," + isHitted);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deserializeFromTextFile(String content) {
        String[] parts = content.split(",");
        setStartX(Integer.parseInt(parts[0]));
        startY = (Integer.parseInt(parts[1]));
        endX = (Integer.parseInt(parts[2]));
        endY = (Integer.parseInt(parts[3]));
        X = (Integer.parseInt(parts[4]));
        Y = (Integer.parseInt(parts[5]));
        color = Integer.parseInt(parts[6]);
        drawAmount = Integer.parseInt(parts[7]);
        isStatic = Boolean.parseBoolean(parts[8]);
        dx = Integer.parseInt(parts[9]);
        dy = Integer.parseInt(parts[10]);
        isHitted = Boolean.parseBoolean(parts[11]);
    }
}
