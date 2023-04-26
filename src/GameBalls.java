import java.awt.*;
import java.util.ArrayList;

public class GameBalls {

    private final ArrayList<GameBall> gameBalls;
    private int currentIndex = 0;

    public GameBalls() {
        gameBalls = new ArrayList<>();
        addBall(new GameBall(436,519,458,541,446,533, 245, 147, 35,2, false, 1, 3));
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
