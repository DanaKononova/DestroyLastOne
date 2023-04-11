import java.awt.*;

import static java.lang.Math.abs;

public class GameBlocks {

    private GameBlock[] gameBlocks;
    private int currentIndex = 0;

    public GameBlocks() {
        int x1 = 0, x2 = 50, y1 = 0, y2 = 30;
        Color color = Color.getHSBColor(0.80f, 1.0f, 1.0f);
        gameBlocks = new GameBlock[100];
        for (int i = 0; i < 20; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 1f));
            x1 += 50;
            x2 += 50;
        }
        y1 += 30;
        x1 = 0;
        x2 = 50;
        y2 += 30;
        for (int i = 20; i < 40; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 1f));
            x1 += 50;
            x2 += 50;
        }
        y1 += 30;
        x1 = 50;
        x2 = 100;
        y2 += 30;
        for (int i = 40; i < 58; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 1f));
            x1 += 50;
            x2 += 50;
        }
        y1 += 30;
        x1 = 100;
        x2 = 150;
        y2 += 30;
        for (int i = 58; i < 74; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 1f));
            x1 += 50;
            x2 += 50;
        }
        y1 += 30;
        x1 = 150;
        x2 = 200;
        y2 += 30;
        for (int i = 74; i < 88; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 1f));
            x1 += 50;
            x2 += 50;
        }
        y1 += 30;
        x1 = 200;
        x2 = 250;
        y2 += 30;
        for (int i = 88; i < 100; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, color, Color.GRAY, 1, true, 1f));
            x1 += 50;
            x2 += 50;
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
