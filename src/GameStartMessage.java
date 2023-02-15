public class GameStartMessage extends GameMessage {
    private Player player;

    public GameStartMessage(Player player) {
        this.player = player;
    }

    @Override
    public void drawMessage() {

    }
}
