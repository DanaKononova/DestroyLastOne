import java.awt.*;
import java.util.ArrayList;

public class BallDesks {

    private ArrayList<BallDesk> ballDesks;
    private int currentIndex = 0;

    public BallDesks() {
        ballDesks = new ArrayList<>();
        BallDesk ballDesk = new BallDesk(400, 540, 560, 552, 480, 546, 164, 36, 75, 3, false, 5, 0);
        addDesk(ballDesk);
    }

    public ArrayList<BallDesk> getBallDesks() {
        return ballDesks;
    }

    public BallDesk getDesk(int index) {
        return (BallDesk) ballDesks.get(index);
    }

    public void addDesk(BallDesk ballDesk) {
        ballDesks.add(ballDesk);
    }

    public void removeDesk(BallDesk ballDesk) {

    }

    public void changeVisibility(BallDesk ballDesk) {

    }
}
