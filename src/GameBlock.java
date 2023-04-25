import java.awt.*;

import static java.lang.Math.abs;

public class GameBlock extends GameFigure {
    private GameBonus gameBonus;
    private Boolean isHitted = false;

    public GameBlock(int startX, int startY, int endX, int endY, int X, int Y, Color color, Color bgColor, int drawAmount, Boolean isStatic, int dx, int dy) {
        super(startX, startY, endX, endY, X, Y, color, bgColor, drawAmount, isStatic, dx, dy);
    }


    @Override
    void figureMove() {
    }

    @Override
    void draw(Graphics2D g2d) {
        if (!isHitted) {
            g2d.setColor(color);
            Rectangle rect = new Rectangle(startX, startY, abs(startX - endX), abs(startY - endY));
            g2d.fill(rect);
            g2d.setColor(bgColor);
            g2d.draw(rect);
        } else {
            startX = 0;
            endX = 0;
            startY = 0;
            endY = 0;
        }
    }

    public GameBonus getGameBonus() {
        return gameBonus;
    }

    public void setGameBonus(GameBonus gameBonus) {
        this.gameBonus = gameBonus;
    }

    public void setHitted(Boolean hitted) {
        isHitted = hitted;
    }
}
