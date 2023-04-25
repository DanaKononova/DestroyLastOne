import java.awt.*;

public class BallDesks {

    private BallDesk[] ballDesks;
    private int currentIndex = 0;

    public BallDesks() {
        ballDesks = new BallDesk[1];
        ballDesks[0] = new BallDesk(400, 540, 560, 552, 480, 546, Color.getHSBColor(0.90f, 1.0f, 0.8f), Color.GRAY, 3, false, 5, 0);
        addDesk(ballDesks[0]);
    }

    public BallDesk[] getBallDesks() {
        return ballDesks;
    }

    public BallDesk getDesk(int index) {
        return ballDesks[index];
    }

    public void addDesk(BallDesk ballDesk) {
        ballDesks[currentIndex] = ballDesk;
        currentIndex++;
    }

    public void removeDesk(BallDesk ballDesk) {

    }

    public void changeVisibility(BallDesk ballDesk) {

    }
}
