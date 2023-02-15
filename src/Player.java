public class Player {
    private int score;
    private int highScore;
    private boolean isVictory = false;
    private GameBall gameBall;
    private BallDesk ballDesk;
    private GameField gameField;

    public Player(int score, int highScore, GameBall gameBall, BallDesk ballDesk, GameField gameField) {
        this.score = score;
        this.highScore = highScore;
        this.gameBall = gameBall;
        this.ballDesk = ballDesk;
        this.gameField = gameField;
    }

    public void playerGameStart(){

    }

    public boolean isPlayerWin(){
        return false;
    }

    public boolean isBallOutside(){
        return false;
    }
}
