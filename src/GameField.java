import javax.swing.*;
import java.awt.*;

public class GameField extends JFrame{
    DisplayObjects displayObjects;
    GameStatistic gameStatistic;
    int width = 1000;
    int height = 600;
    int background;
    GameMessageBox gameMessageBox;

    public GameField() throws InterruptedException {
        setTitle("Destroy Last One");
        displayObjects = new DisplayObjects();
        getContentPane().add(displayObjects);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        getContentPane().setBackground(Color.blue);
        setVisible(true);
        displayObjects.drawAll();
    }

    public void isFinished(){
    }

    public DisplayObjects getDisplayFigures() {
        return displayObjects;
    }

    public void setDisplayFigures(DisplayObjects displayObjects) {
        this.displayObjects = displayObjects;
    }
}
