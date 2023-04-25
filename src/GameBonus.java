import java.awt.*;

public class GameBonus extends GameFigure{
    private int amount;

    public GameBonus(int startX, int startY, int endX, int endY, int centerX, int centerY, Color color, Color bgColor, int drawAmount, Boolean isStatic, int dx, int dy) {
        super(startX, startY, endX, endY, centerX, centerY, color, bgColor, drawAmount, isStatic, dx, dy);
    }

    @Override
    void figureMove() {
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
