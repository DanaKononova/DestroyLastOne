import java.awt.*;

public class GameBalls {

    private GameBall[] gameBalls;
    private int currentIndex = 0;

    public GameBalls() {
        gameBalls = new GameBall[1];
        addBall(new GameBall(435,522,459,546,446,533, Color.getHSBColor(0.10f, 0.9f, 0.95f),Color.GRAY,3, false, (float) (Math.PI * 0.85)));
    }

    public GameBall[] getGameBalls() {
        return gameBalls;
    }

    public GameBall getBall(int index){
        return gameBalls[index];
    }

    public void addBall(GameBall gameBall){
        gameBalls[currentIndex] = gameBall;
        currentIndex++;
    }
    public void removeBall(GameBall gameBall){

    }

    public void changeVisibility(BallDesk ballDesk){

    }
}
