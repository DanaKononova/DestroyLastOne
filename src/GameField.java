public class GameField {
    private GameBlock[] gameBlocks;
    private GamePlayStatic gamePlayStatic;
    private float width;
    private float height;

    public GameField(GameBlock[] gameBlocks, GamePlayStatic gamePlayStatic, float width, float height) {
        this.gameBlocks = gameBlocks;
        this.gamePlayStatic = gamePlayStatic;
        this.width = width;
        this.height = height;
    }

    public void collectAndDrawBlocks(){

    }

    public void destroyBlocks(){

    }

    public boolean isAllDestroyed(){
        return false;
    }
}
