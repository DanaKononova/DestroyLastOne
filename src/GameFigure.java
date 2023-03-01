public abstract class GameFigure{
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int X;
    private int Y;
    private int color;
    private int bgColor;
    private int drawAmount;

    public GameFigure(int startX, int startY, int endX, int endY, int X, int Y, int color, int bgColor, int drawAmount) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.X = X;
        this.Y = Y;
        this.color = color;
        this.bgColor = bgColor;
        this.drawAmount = drawAmount;
    }

    abstract void figureMove() ;

    abstract void didHitFigure(GameFigure gameFigure);

    abstract void draw();

    public float getStartX() {
        return startX;
    }

    public float getStartY() {
        return startY;
    }
}
