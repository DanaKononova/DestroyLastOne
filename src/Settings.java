import java.io.Serializable;

public class Settings implements Serializable {
    private int volume;
    private int brightness;
    private int difficulty;
    transient SettingsFrame settingsFrame;
    String screen;

    Settings() {
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

    public void setSettingsFrame(SettingsFrame settingsFrame) {
        this.settingsFrame = settingsFrame;
    }
    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }
}