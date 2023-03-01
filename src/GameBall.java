public class GameBall extends GameFigure{
    private int direction;

    public GameBall(int startX, int startY, int endX, int endY, int centerX, int centerY, int color, int bgColor, int drawAmount) {
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

    public void changeDirection(){

    }
}
