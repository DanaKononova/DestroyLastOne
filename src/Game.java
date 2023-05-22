import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Game {
    static GameField gameField;
    Players players;
    static Menu menu;
    Settings settings;
    static Timer timer;
    static long currTime = 0L;
    StatusBar statusBar;

    public Game() throws InterruptedException {
        settings = new Settings();
        statusBar = new StatusBar();
        gameField = new GameField(this, 1200, 600);
    }

    public static void main(String[] args) throws InterruptedException {
        new Game();
    }

    public static void gameLoop() throws InterruptedException {
        int delay = 0;
        timer = new Timer(delay, new ActionListener() {
            long startTime = System.currentTimeMillis();

            @Override
            public void actionPerformed(ActionEvent e) {
                move();
                checkCollision();
                try {
                    draw();
                } catch (InterruptedException ex) {
                    System.out.println(e.toString());
                }
                long elapsedTime = System.currentTimeMillis() - startTime;
                if (elapsedTime >= 1000L) {
                        currTime += 1000L;
                        gameField.formatTime(currTime);
                        startTime = System.currentTimeMillis();
                }
            }
        });
        timer.start();
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
                        boolean isBlockDestroyed = figure.isCollides(anotherFigure);
                        if (isBlockDestroyed) gameField.setProgressValue();
                    }
                }
            }
        }
    }

    private static void draw() throws InterruptedException {
        gameField.getDisplayFigures().repaint();
    }

    public void startGame(int width, int height) throws InterruptedException {
        if(gameField != null) gameField.close();
        gameField = new GameField(this, width, height);
    }

    public void startNewGame(int width, int height) throws InterruptedException {
        if (timer != null) timer.stop();
        try {
            currTime = 0L;
            startGame(width, height);
            gameLoop();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void pauseGame() {
        if(timer != null) timer.stop();
    }

    public void resumeGame() throws InterruptedException {
        if (timer != null) {
            timer.start();
        } else gameLoop();
    }

    public void loadFromFile() throws InterruptedException {
        if (gameField == null)
            gameField = new GameField(this, 1200, 600);
        ProxySerialization proxy = new ProxySerialization();
       // proxy.deserializeFromJsonFile("SaveGame.json", gameField.displayObjects.getFigures(), settings, statusBar);
        proxy.deserializeFields("SaveGame.txt", gameField.displayObjects.getFigures(), this);
        for (GameFigure figure : gameField.displayObjects.getFigures()) {
            if (figure instanceof BallDesk) {
                gameField.displayObjects.currentDesk = (BallDesk) figure;
            }
        }
        gameField.setNullStatusBar();
        gameField.updateStatusBar();
    }

    public void saveInFile() throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        ProxySerialization proxy = new ProxySerialization();
        try (PrintWriter writer = new PrintWriter(new FileWriter("SaveGame.txt", false))) {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (GameFigure figure: gameField.displayObjects.getFigures()){
            proxy.serializeField("SaveGame.txt", figure);
        }
        proxy.serializeField("SaveGame.txt", settings);
        proxy.serializeField("SaveGame.txt", statusBar);
        // proxy.serializeToJsonFile("SaveGame.json", gameField.displayObjects.getFigures(), settings, statusBar);
    }

    public void settingsGame() throws InterruptedException {
        if (timer != null) timer.stop();
        settings.setSettingsFrame(new SettingsFrame(settings, this));
    }


    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public void setStatusBar(StatusBar statusBar) {
        this.statusBar = statusBar;
    }

}
