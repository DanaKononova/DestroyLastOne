import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Settings implements Serialization {
    private int volume;
    private int brightness;
    private int difficulty;
    SettingsFrame settingsFrame;
    Game game;

    Settings(Game game) {
        this.game = game;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void serializeToTextFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(volume + "," + brightness + "," + difficulty);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deserializeFromTextFile(String content) {
        String[] parts = content.split(",");
        volume = (Integer.parseInt(parts[0]));
        brightness = (Integer.parseInt(parts[1]));
        difficulty = (Integer.parseInt(parts[2]));
    }
}