public class GameEndMessage implements GameMessage {
    public Player player;
    public PlayerStatistic playerStatistic;

    public GameEndMessage(Player player, PlayerStatistic playerStatistic) {
        this.player = player;
        this.playerStatistic = playerStatistic;
    }

    @Override
    public void drawMessage() {

    }
}
