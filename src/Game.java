public class Game {
    static GameField gameField;
    Players players;

    public static void main(String[] args) throws InterruptedException {
        gameField = new GameField();
        gameLoop();
    }

    public static void gameLoop() throws InterruptedException {
        while (true) {
            move();
            checkCollision();
            draw();
        }
    }

    private static void move() {

        for (GameFigure figure : gameField.getDisplayFigures().getFigures()) {
            if (!figure.isStatic) {
                figure.figureMove();
            }
        }
    }

    private static void checkCollision() {
        for (GameFigure figure : gameField.getDisplayFigures().getFigures()) {
            if (!figure.isStatic) {
                for (GameFigure anotherFigure : gameField.getDisplayFigures().getFigures()) {
                    if (!figure.equals(anotherFigure)) {
                        figure.isCollides(anotherFigure);
                    }
                }
            }
        }
    }

    private static void draw() throws InterruptedException {
        gameField.getDisplayFigures().repaint();
        Thread.sleep(7);
    }

    public static void pauseGame() {

    }

    public static void resumeGame() {

    }

    public static void gameFinished(){

    }

    public static void loadFromFile() {

    }

    public static void saveInFile() {

    }
}
