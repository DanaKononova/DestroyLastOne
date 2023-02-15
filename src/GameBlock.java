public class GameBlock extends GameFigure{
    private float width;
    private float height;

    public GameBlock(float startX, float startY, float width, float height, String color) {
        super(startX, startY, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void figureMove() {

    }
}
