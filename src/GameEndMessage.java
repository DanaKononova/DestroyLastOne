public class GameEndMessage extends GameMessage{
    public Player player;
    public GamePlayStatic gamePlayStatic;

    public GameEndMessage(Player player, GamePlayStatic gamePlayStatic) {
        this.player = player;
        this.gamePlayStatic = gamePlayStatic;
    }

    @Override
    public void drawMessage() {

    }
}
