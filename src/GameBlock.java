import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;

import static java.lang.Math.abs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameBlock extends GameFigure {
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
    public Boolean getHitted() {
        return isHitted;
    }

}
