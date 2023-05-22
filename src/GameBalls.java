import java.awt.*;
import java.util.ArrayList;

public class GameBalls {

    private final ArrayList<GameBall> gameBalls;
    private int currentIndex = 0;

    public GameBalls(double sizeKoeff, int width, int height) {
        gameBalls = new ArrayList<>();
        addBall(new GameBall((int)(436*sizeKoeff),(int)(519*sizeKoeff),(int)(458*sizeKoeff),(int)(541*sizeKoeff),(int)(446*sizeKoeff),(int)(533*sizeKoeff), new Color(245, 147, 35).getRGB(),2, false, 1, 3, width, height));
    }

    public ArrayList<GameBall> getGameBalls() {
        return gameBalls;
    }

    public GameBall getBall(int index){
        return gameBalls.get(index);
    }

    public void addBall(GameBall gameBall){
        gameBalls.add(gameBall);
    }
    public void removeBall(GameBall gameBall){
    }

    public void changeVisibility(BallDesk ballDesk){

    }
}
