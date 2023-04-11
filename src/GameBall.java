import java.awt.*;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class GameBall extends GameFigure {

    public GameBall(int startX, int startY, int endX, int endY, int centerX, int centerY, Color color, Color bgColor, int drawAmount, Boolean isStatic, float direction) {
        super(startX, startY, endX, endY, centerX, centerY, color, bgColor, drawAmount, isStatic, direction);
    }

    @Override
    void figureMove() {
        if (startX <= 0) {
            direction = (2 * (float) (PI / 2) - direction);
        } else {
            if (endX >= 1000) {
                direction = (2 * (float) (PI / 2 * 3) - direction);
            } else {
                if (startY <= 0) {
                    direction = (2 * (float) (PI) - direction);
                }
            }
        }
        float dx = (float) Math.cos(direction) * drawAmount;
        float dy = (float) Math.sin(direction) * drawAmount;

        startX = ((int) (startX + dx));
        endX = ((int) (endX + dx));
        startY = ((int) (startY + dy));
        endY = ((int) (endY + dy));
    }

    @Override
    void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(startX, startY, abs(startX - endX), abs(startY - endY));
    }

    public void changeDirection() {
    }
}
