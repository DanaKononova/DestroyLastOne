import java.awt.*;
import java.awt.event.KeyEvent;

import static java.lang.Math.abs;

public class BallDesk extends GameFigure {
    KeyEvent key;

    public BallDesk(int startX, int startY, int endX, int endY, int centerX, int centerY, Color color, Color bgColor, int drawAmount, boolean isStatic, float direction) {
        super(startX, startY, endX, endY, centerX, centerY, color, bgColor, drawAmount, isStatic, direction);
    }

    @Override
    void figureMove() {
        if (key != null) {
            int keyCode = key.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT) {
                startX = (startX - drawAmount);
                endX = (endX - drawAmount);
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                startX = (startX + drawAmount);
                endX = (endX + drawAmount);
            }
            if (startX < 0) {
                endX = (endX - startX);
                startX = 0;
            } else if (endX > 1000) {
                startX = (1000 - (endX - startX));
                endX = 1000;
            }
        }
    }

    @Override
    void draw(Graphics2D g2d) {
        g2d.setColor(color);
        Rectangle rect = new Rectangle(startX, startY, abs(startX - endX), abs(startY - endY));
        g2d.fill(rect);
        g2d.setColor(bgColor);
        g2d.draw(rect);
    }
}
