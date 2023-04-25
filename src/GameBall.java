import java.awt.*;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class GameBall extends GameFigure {

    public GameBall(int startX, int startY, int endX, int endY, int centerX, int centerY, Color color, Color bgColor, int drawAmount, Boolean isStatic, int dx, int dy) {
        super(startX, startY, endX, endY, centerX, centerY, color, bgColor, drawAmount, isStatic, dx, dy);
    }

    @Override
    void figureMove() {
        if (endY < 0) dy = -dy;
        if (startX < 0 || endX > 1000) dx = -dx;
        startX = startX + dx;
        endX = endX + dx;
        startY = startY - dy;
        endY = endY - dy;
        if (dx != 0) dx = dx / abs(dx);
        if (dy != 0) dy = dy / abs(dy);
    }

    @Override
    void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(startX, startY, abs(startX - endX), abs(startY - endY));
    }
}
