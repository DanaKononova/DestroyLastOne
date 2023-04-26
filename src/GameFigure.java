import java.awt.*;
import static java.lang.Math.random;

public abstract class GameFigure implements Serialization{
    int startX;
    int startY;
    int endX;
    int endY;
    int X;
    int Y;
    int colorR;
    int colorG;
    int colorB;
   // Color bgColor;
    int drawAmount;
    Boolean isStatic;
    int dx;
    int dy;
    public GameFigure(int startX, int startY, int endX, int endY, int X, int Y, int colorR, int colorG, int colorB, int drawAmount, boolean isStatic, int dx, int dy) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.X = X;
        this.Y = Y;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
        this.drawAmount = drawAmount;
        this.isStatic = isStatic;
        this.dx = dx;
        this.dy = dy;
    }

    public GameFigure(){

    }

    abstract boolean figureMove() ;

    public Boolean isCollides(GameFigure gameFigure){
        int x1 = startX;
        int x2 = endX;
        int y1 = startY;
        int y2 = endY;
        int x3 = gameFigure.startX;
        int x4 = gameFigure.endX;
        int y3 = gameFigure.startY;
        int y4 = gameFigure.endY;
        boolean res = (x2 >= x3) && (x1 <= x4) && (y2 >= y3) && (y1 <= y4);
        if (res) {
            dx = (dx + (int)(random() * 5)) * (-1);
            dy = (dy) * (-1);
            if (gameFigure.getClass().toString().equals("class GameBlock")) {
                GameBlock block = (GameBlock) gameFigure;
                block.setHitted(true);
            }
        }
        return res;
    }

    abstract void draw(Graphics2D g2d);

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getDrawAmount() {
        return drawAmount;
    }

    public void setDrawAmount(int drawAmount) {
        this.drawAmount = drawAmount;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getColorR() {
        return colorR;
    }

    public void setColorR(int colorR) {
        this.colorR = colorR;
    }

    public int getColorG() {
        return colorG;
    }

    public void setColorG(int colorG) {
        this.colorG = colorG;
    }

    public int getColorB() {
        return colorB;
    }

    public void setColorB(int colorB) {
        this.colorB = colorB;
    }

    public Boolean getStatic() {
        return isStatic;
    }

    public void setStatic(Boolean isStatic) {
        this.isStatic = isStatic;
    }
}
