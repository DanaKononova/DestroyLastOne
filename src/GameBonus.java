import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Field;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameBonus extends GameFigure implements Serializable {
    private int amount;

    public GameBonus(int startX, int startY, int endX, int endY, int centerX, int centerY, int color, int drawAmount, Boolean isStatic, int dx, int dy) {
        super(startX, startY, endX, endY, centerX, centerY, color, drawAmount, isStatic, dx, dy);
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
        field = this.getClass().getDeclaredField("amount");
        field.setAccessible(true);
        field.set(this, this.amount);
        return this;
    }

    @Override
    public void deserializeFromField() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getSuperclass().getDeclaredField("startX");
        field.setAccessible(true);
        setStartX((Integer) field.get(this));
        field = super.getClass().getSuperclass().getDeclaredField("startY");
        field.setAccessible(true);
        startY = (int) field.get(this);
        field = this.getClass().getSuperclass().getDeclaredField("endX");
        field.setAccessible(true);
        endX = (int) field.get(this);
        field = this.getClass().getSuperclass().getDeclaredField("endY");
        field.setAccessible(true);
        endY = (int) field.get(this);
        field = this.getClass().getSuperclass().getDeclaredField("X");
        field.setAccessible(true);
        X = (int) field.get(this);
        field = this.getClass().getSuperclass().getDeclaredField("Y");
        field.setAccessible(true);
        Y = (int) field.get(this);
        field = this.getClass().getSuperclass().getDeclaredField("color");
        field.setAccessible(true);
        color = (int) field.get(this);
        field = this.getClass().getSuperclass().getDeclaredField("drawAmount");
        field.setAccessible(true);
        drawAmount = (int) field.get(this);
        field = this.getClass().getSuperclass().getDeclaredField("dx");
        field.setAccessible(true);
        dx = (int) field.get(this);
        field = this.getClass().getSuperclass().getDeclaredField("dy");
        field.setAccessible(true);
        dy = (int) field.get(this);
        field = this.getClass().getSuperclass().getDeclaredField("isStatic");
        field.setAccessible(true);
        isStatic = (Boolean) field.get(this);
        field = this.getClass().getDeclaredField("amount");
        field.setAccessible(true);
        amount = (int) field.get(this);
    }

    @Override
    public void serializeToTextFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(getStartX() + "," + startY + "," + endX + "," + endY + "," + X + "," + Y + "," + color + "," + drawAmount + "," + dx + "," + dy + "," + amount);
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
        dx = Integer.parseInt(parts[8]);
        dy = Integer.parseInt(parts[9]);
        amount = Integer.parseInt(parts[10]);
    }
}
