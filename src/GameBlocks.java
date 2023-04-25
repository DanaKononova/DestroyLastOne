import java.awt.*;

import static java.lang.Math.abs;

public class GameBlocks {

    private GameBlock[] gameBlocks;
    private int currentIndex = 0;

    public GameBlocks() {
        int x1 = 0, x2 = 70, y1 = 0, y2 = 50;
        Color color = Color.getHSBColor(0.80f, 1.0f, 1.0f);
        gameBlocks = new GameBlock[72];
        for (int i = 0; i < 14; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 0, 0));
            x1 += 70;
            x2 += 70;
        }
        y1 += 50;
        x1 = 0;
        x2 = 70;
        y2 += 50;
        for (int i = 14; i < 28; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 0, 0));
            x1 += 70;
            x2 += 70;
        }
        y1 += 50;
        x1 = 70;
        x2 = 140;
        y2 += 50;
        for (int i = 28; i < 40; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 0, 0));
            x1 += 70;
            x2 += 70;
        }
        y1 += 50;
        x1 = 70;
        x2 = 140;
        y2 += 50;
        for (int i = 40; i < 52; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 0, 0));
            x1 += 70;
            x2 += 70;
        }
        y1 += 50;
        x1 = 140;
        x2 = 210;
        y2 += 50;
        for (int i = 52; i < 62; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 0, 0));
            x1 += 70;
            x2 += 70;
        }
        y1 += 50;
        x1 = 140;
        x2 = 210;
        y2 += 50;
        for (int i = 62; i < 72; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 0, 0));
            x1 += 70;
            x2 += 70;
        }
    }

    public GameBlock[] getGameBlocks() {
        return gameBlocks;
    }

    public GameBlock getBlock(int index) {
        return null;
    }

    public void addBlock(GameBlock gameBlock) {
        gameBlocks[currentIndex] = gameBlock;
        currentIndex++;
    }

    public void removeBlock(GameBlock gameBlock) {
    }

    public void changeVisibility(BallDesk ballDesk) {
    }

    public boolean isAllDestroyed() {
        return false;
    }
}
