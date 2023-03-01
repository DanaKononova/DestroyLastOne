public class Player {
    private String name;
    private PlayerStatistic playerStatistic;
    private GameBalls gameBalls;
    private BallDesks ballDesks;

    public Player(String name, PlayerStatistic playerStatistic, GameBalls gameBalls, BallDesks ballDesks) {
        this.name = name;
        this.playerStatistic = playerStatistic;
        this.gameBalls = gameBalls;
        this.ballDesks = ballDesks;
    }

    public boolean isPlayerWin(){
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerStatistic getGamePlayStatistic() {
        return playerStatistic;
    }

    public void setGamePlayStatistic(PlayerStatistic playerStatistic) {
        this.playerStatistic = playerStatistic;
    }

    public GameBalls getGameBalls() {
        return gameBalls;
    }

    public void setGameBalls(GameBalls gameBalls) {
        this.gameBalls = gameBalls;
    }

    public BallDesks getBallDesks() {
        return ballDesks;
    }

    public void setBallDesks(BallDesks ballDesks) {
        this.ballDesks = ballDesks;
    }
}
