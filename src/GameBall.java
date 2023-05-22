import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.Serializable;
import java.lang.reflect.Field;

import static java.lang.Math.abs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameBall extends GameFigure implements Serializable {
    private int screenW;
    private int screenH;
    public int getScreenW() {
        return screenW;
    }

    public void setScreenW(int screenW) {
        this.screenW = screenW;
    }

    public int getScreenH() {
        return screenH;
    }

    public void setScreenH(int screenH) {
        this.screenH = screenH;
    }

    public GameBall(int startX, int startY, int endX, int endY, int centerX, int centerY, int color, int drawAmount, Boolean isStatic, int dx, int dy, int screenW, int screenH) {
        super(startX, startY, endX, endY, centerX, centerY, color, drawAmount, isStatic, dx, dy);
        this.screenW = screenW;
        this.screenH = screenH;
    }
    GameBall(){

    }

    @Override
    boolean figureMove() {
        if (startY > screenH) return false;
        if (endY < 0) dy = -dy;
        if (getStartX() < 0 || endX > screenW) dx = -dx;
        setStartX(getStartX() + dx);
        endX = endX + dx;
        startY = startY - dy;
        endY = endY - dy;
        if (dx != 0) dx = drawAmount * dx / abs(dx);
        if (dy != 0) dy = drawAmount * dy / abs(dy);
        return true;
    }

    @Override
    void draw(Graphics2D g2d) {
        g2d.setColor(new Color(color));
        g2d.fillOval(getStartX()-1, startY-1, abs(getStartX() - endX-1), abs(startY - endY-1));
    }

    public void setSpeed(int speed) {
        drawAmount = speed;
    }
}
