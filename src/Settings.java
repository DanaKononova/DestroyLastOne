import java.beans.Transient;
import java.io.Serializable;
import java.lang.reflect.Field;

public class Settings implements Serializable {
    int volume;
    int brightness;
    int difficulty;
    transient SettingsFrame settingsFrame;

    Settings() {
    }

    Object createFieldObject() throws IllegalAccessException, NoSuchFieldException {
        Field field = this.getClass().getDeclaredField("volume");
        field.setAccessible(true);
        field.set(this, this.volume);
        field = super.getClass().getDeclaredField("brightness");
        field.setAccessible(true);
        field.set(this, this.brightness);
        field = this.getClass().getDeclaredField("difficulty");
        field.setAccessible(true);
        field.set(this, this.difficulty);
        return this;
    }

    public void deserializeFromField() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField("volume");
        field.setAccessible(true);
        volume = (int) field.get(this);
        field = super.getClass().getDeclaredField("brightness");
        field.setAccessible(true);
        brightness = (int) field.get(this);
        field = this.getClass().getDeclaredField("difficulty");
        field.setAccessible(true);
        difficulty = (int) field.get(this);
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

    public SettingsFrame getSettingsFrame() {
        return settingsFrame;
    }

    public void setSettingsFrame(SettingsFrame settingsFrame) {
        this.settingsFrame = settingsFrame;
    }
}