import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class Game {
    static GameField gameField;
    Players players;
    static Menu menu;
    Settings settings;
    static Timer timer;

    public Game() throws InterruptedException {
        settings = new Settings();
        gameField = new GameField(this);
    }

    public static void main(String[] args) throws InterruptedException {
        new Game();
    }

    public static void gameLoop() throws InterruptedException {
        int delay = 0;
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move();
                checkCollision();
                try {
                    draw();
                } catch (InterruptedException ex) {
                    System.out.println(e.toString());
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
                        figure.isCollides(anotherFigure);
                    }
                }
            }
        }
    }

    private static void draw() throws InterruptedException {
        gameField.getDisplayFigures().repaint();
    }

    public void startGame() throws InterruptedException {
        gameField = new GameField(this);
    }

    public void startNewGame() throws InterruptedException {
        timer.stop();
        try {
            startGame();
            gameLoop();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void pauseGame() {
        timer.stop();
    }

    public void resumeGame() throws InterruptedException {
        if (timer != null) {
            timer.start();
        } else gameLoop();
    }

    public void settingsGame() throws InterruptedException {
        timer.stop();
        settings.setSettingsFrame(new SettingsFrame(settings));
    }

    public void loadFromFile() throws InterruptedException {
        if (gameField == null)
            gameField = new GameField(this);
        ProxySerialization proxy = new ProxySerialization();
        //proxy.deserializeFromJsonFile("SaveGame.json", gameField.displayObjects.getFigures(), settings);
        proxy.deserializeFields("SaveGame.txt", gameField.displayObjects.getFigures());
        for (GameFigure figure : gameField.displayObjects.getFigures()) {
            if (figure instanceof BallDesk) {
                gameField.displayObjects.currentDesk = (BallDesk) figure;
                break;
            }
        }
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
       // proxy.serializeToJsonFile("SaveGame.json", gameField.displayObjects.getFigures(), settings);
    }
}
