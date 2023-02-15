public abstract class GameFigure{
    private float startX;
    private float startY;
    private String color;

    public GameFigure(float startX, float startY, String color) {
        this.startX = startX;
        this.startY = startY;
        this.color = color;
    }

    public void figureMove() {
    }
}
