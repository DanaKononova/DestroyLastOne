import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Field;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameBonus extends GameFigure {
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

}
