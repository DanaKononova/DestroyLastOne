public class GameStartMessage implements GameMessage {
    private Players players;
    //окошко, два кнопки и текстовое поле

    public GameStartMessage(Players players) {
        this.players = players;
    }

    @Override
    public void drawMessage() {

    }

    public void setCurrentPlayer(){

    }
}
