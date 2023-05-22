import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class GameBlocks {

    private ArrayList<GameBlock> gameBlocks;
    private int currentIndex = 0;

    public GameBlocks(double sizeKoeff) {
        int xSize = (int) (70 * sizeKoeff);
        int ySize = (int)(50* sizeKoeff);
        int x1 = 0, x2 = xSize, y1 = 0, y2 = ySize;
        Color color = Color.getHSBColor(0.80f, 1.0f, 1.0f);
        gameBlocks = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, new Color(182, 38, 192).getRGB(), 1, true, 0, 0));
            x1 += xSize;
            x2 += xSize;
        }
        y1 += ySize;
        x1 = 0;
        x2 = xSize;
        y2 += ySize;
        for (int i = 14; i < 28; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2,new Color(182, 38, 192).getRGB(), 1, true, 0, 0));
            x1 += xSize;
            x2 += xSize;
        }
        y1 += ySize;
        x1 = xSize;
        x2 = x1 + xSize;
        y2 += ySize;
        for (int i = 28; i < 40; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2,new Color(182, 38, 192).getRGB(), 1, true, 0, 0));
            x1 += xSize;
            x2 += xSize;
        }
        y1 += ySize;
        x1 = xSize;
        x2 = x1 + xSize;
        y2 += ySize;
        for (int i = 40; i < 52; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, new Color(182, 38, 192).getRGB(), 1, true, 0, 0));
            x1 += xSize;
            x2 += xSize;
        }
        y1 += ySize;
        x1 = xSize * 2;
        x2 = x1 + xSize;
        y2 += ySize;
        for (int i = 52; i < 62; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, new Color(182, 38, 192).getRGB(), 1, true, 0, 0));
            x1 += xSize;
            x2 += xSize;
        }
        y1 += ySize;
        x1 = xSize * 2;
        x2 = xSize + x1;
        y2 += ySize;
        for (int i = 62; i < 72; i++) {
            addBlock(new GameBlock(x1, y1, x2, y2, abs(x1 - x2) / 2, abs(y1 - y2) / 2, new Color(182, 38, 192).getRGB(), 1, true, 0, 0));
            x1 += xSize;
            x2 += xSize;
        }
    }

    public ArrayList<GameBlock> getGameBlocks() {
        return gameBlocks;
    }

    public GameBlock getBlock(int index) {
        return null;
    }

    public void addBlock(GameBlock gameBlock) {
        gameBlocks.add(gameBlock);
    }

    public void removeBlock(GameBlock gameBlock) {
    }

    public void changeVisibility(BallDesk ballDesk) {
    }

    public boolean isAllDestroyed() {
        return false;
    }
}
