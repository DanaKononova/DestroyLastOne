import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import static java.lang.Math.abs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BallDesk extends GameFigure implements Serializable {
    transient KeyEvent key;

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

    private int screenW;
    private int screenH;

    public BallDesk(int startX, int startY, int endX, int endY, int centerX, int centerY, int color, int drawAmount, boolean isStatic, int dx, int dy, int screenW, int screenH) {
        super(startX, startY, endX, endY, centerX, centerY, color, drawAmount, isStatic, dx, dy);
        this.screenW = screenW;
        this.screenH = screenH;
    }

    BallDesk(){

    }

    @Override
    boolean figureMove() {
        if (key != null) {
            int keyCode = key.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT) {
                setStartX(getStartX() - drawAmount);
                endX = (endX - drawAmount);
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                setStartX(getStartX() + drawAmount);
                endX = (endX + drawAmount);
            }
            if (getStartX() < 0) {
                endX = (endX - getStartX());
                setStartX(0);
            } else if (endX > screenW) {
                setStartX(screenW - (endX - getStartX()));
                endX = screenW;
            }
        }
        return true;
    }

    @Override
    void draw(Graphics2D g2d) {
        g2d.setColor(new Color(color));
        Rectangle rect = new Rectangle(getStartX(), startY, abs(getStartX() - endX), abs(startY - endY));
        g2d.fill(rect);
        g2d.draw(rect);
    }
}
