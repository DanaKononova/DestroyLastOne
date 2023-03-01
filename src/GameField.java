public class GameField {
    private DisplayFigure displayFigure;
    private GameStatistic gameStatistic;
    private int width;
    private int height;
    private int background;
    private GameStartMessage gameStartMessage;
    private GameEndMessage gameEndMessage;

    public GameField(DisplayFigure displayFigure, GameStatistic gameStatistic, GameStartMessage gameStartMessage, GameEndMessage gameEndMessage, int width, int height, int background) {
        this.displayFigure = displayFigure;
        this.width = width;
        this.height = height;
        this.background = background;
        this.gameStartMessage = gameStartMessage;
        this.gameEndMessage = gameEndMessage;
    }

    public void setBackground(){

    }

    public void isFinished(){

    }

    public DisplayFigure getDisplayFigure() {
        return displayFigure;
    }

    public void setDisplayFigure(DisplayFigure displayFigure) {
        this.displayFigure = displayFigure;
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
