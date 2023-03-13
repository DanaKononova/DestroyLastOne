public class GameField {
    private DisplayObject displayObject;
    private GameStatistic gameStatistic;
    private int width;
    private int height;
    private int background;
    private GameMessageBox gameMessageBox;

    public GameField(DisplayObject displayObject, GameStatistic gameStatistic, GameMessageBox gameMessageBox, int width, int height, int background) {
        this.displayObject = displayObject;
        this.width = width;
        this.height = height;
        this.background = background;
        this.gameMessageBox = gameMessageBox;
    }

    public void setBackground(){

    }

    public void isFinished(){

    }

    public DisplayObject getDisplayFigure() {
        return displayObject;
    }

    public void setDisplayFigure(DisplayObject displayObject) {
        this.displayObject = displayObject;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
}
