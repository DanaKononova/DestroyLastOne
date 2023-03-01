public class GameBlock extends GameFigure{
    private GameBonus gameBonus;

    public GameBlock(int startX, int startY, int endX, int endY, int centerX, int centerY, int color, int bgColor, int drawAmount) {
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

    public GameBonus getGameBonus() {
        return gameBonus;
    }

    public void setGameBonus(GameBonus gameBonus) {
        this.gameBonus = gameBonus;
    }
}
