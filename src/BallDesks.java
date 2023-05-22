import java.awt.*;
import java.util.ArrayList;

public class BallDesks {

    private ArrayList<BallDesk> ballDesks;
    private int currentIndex = 0;

    public BallDesks(double sizeKoeff, int screenW, int screenH) {
        ballDesks = new ArrayList<>();
        BallDesk ballDesk = new BallDesk((int)(400*sizeKoeff), (int)(540*sizeKoeff), (int)(560*sizeKoeff), (int)(552*sizeKoeff), (int)(480*sizeKoeff), (int)(546*sizeKoeff), new Color(164, 36, 75).getRGB(), 3, false, 5, 0, screenW, screenH);
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
