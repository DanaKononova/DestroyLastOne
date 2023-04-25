import java.awt.*;
import static java.lang.Math.random;

public abstract class GameFigure{
    int startX;
    int startY;
    int endX;
    int endY;
    int X;
    int Y;
    Color color;
    Color bgColor;
    int drawAmount;
    Boolean isStatic;
    int dx;
    int dy;
    public GameFigure(int startX, int startY, int endX, int endY, int X, int Y, Color color, Color bgColor, int drawAmount, boolean isStatic, int dx, int dy) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.X = X;
        this.Y = Y;
        this.color = color;
        this.bgColor = bgColor;
        this.drawAmount = drawAmount;
        this.isStatic = isStatic;
        this.dx = dx;
        this.dy = dy;
    }

    abstract void figureMove() ;

    public Boolean isCollides(GameFigure gameFigure){
        int x1 = startX;
        int x2 = endX;
        int y1 = startY;
        int y2 = endY;
        int x3 = gameFigure.startX;
        int x4 = gameFigure.endX;
        int y3 = gameFigure.startY;
        int y4 = gameFigure.endY;
        boolean res = x2 >= x3 && x1 <= x4 && y2 >= y3 && y1 <= y4;
        if (res) {
            dx = (dx + (int)(random() * 3)) * (-1);
            dy = (dy) * (-1);
            if (gameFigure.getClass().toString().equals("class GameBlock")) {
                GameBlock block = (GameBlock) gameFigure;
                block.setHitted(true);
            }
        }
        return res;
    };

    abstract void draw(Graphics2D g2d);
}
