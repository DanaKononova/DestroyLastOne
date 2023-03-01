public class GameBonus extends GameFigure{
    private int amount;

    public GameBonus(int startX, int startY, int endX, int endY, int centerX, int centerY, int color, int bgColor, int drawAmount) {
        super(startX, startY, endX, endY, centerX, centerY, color, bgColor, drawAmount);
    }

    @Override
    void figureMove() {

    }

    @Override
    void didHitFigure(GameFigure gameFigure) {

    }

    @Override
    void draw() {

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
