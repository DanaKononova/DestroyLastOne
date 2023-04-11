import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DisplayObjects extends JPanel {
    private GameFigure figures[];
    private int figuresAmount = 102;
    private BallDesk currentDesk;
    private int currentIndex = 0;

    public DisplayObjects() {
        figures = new GameFigure[figuresAmount];
        GameBlocks blocks = new GameBlocks();
        addFigure(blocks.getGameBlocks());
        BallDesks desks = new BallDesks();
        currentDesk = desks.getDesk(0);
        addFigure(desks.getBallDesks());
        GameBalls balls = new GameBalls();
        addFigure(balls.getGameBalls());
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.pink);
        Graphics2D g2d = (Graphics2D) g;
        for (GameFigure figure : figures) {
            figure.draw(g2d);
        }
    }

    public void addFigure(GameFigure figures[]) {
        for (GameFigure figure : figures) {
            this.figures[currentIndex] = figure;
            currentIndex++;
        }
    }

    public void drawAll() throws InterruptedException {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                currentDesk.key = e;
            }
        });
        while (true) {
            for (GameFigure figure : figures) {
                if (!figure.isStatic) {
                    figure.figureMove();
                    for (GameFigure anotherFigure : figures) {
                        if (!figure.equals(anotherFigure)) {
                            figure.isCollides(anotherFigure);
                        }
                    }
                }
            }
            this.repaint();
            Thread.sleep(7);
        }
    }

    public void removeFigure(GameFigure figures[]) {
    }

    public GameFigure[] getFigures() {
        return figures;
    }

    public void setFigures(GameFigure[] figures) {
        this.figures = figures;
    }
}
