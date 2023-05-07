import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameField extends JFrame{
    DisplayObjects displayObjects;
    GameStatistic gameStatistic;
    int width = 1200;
    int height = 600;
    int background;
    GameMessageBox gameMessageBox;
    Game game;

    public GameField(Game game) throws InterruptedException {
        this.game = game;

        setTitle("Destroy Last One");
        displayObjects = new DisplayObjects();
        getContentPane().add(displayObjects);

        JPanel menuPanel = new JPanel(new GridLayout(8, 1, 0, 5));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20)); // добавляем отступы в 10 пикселей сверху, снизу, слева и справа
        JButton menuButton = new JButton("Меню");
        JButton newGameButton = new JButton("Начать новую игру");
        newGameButton.setVisible(false);
        JButton resumeGameButton = new JButton("Продолжить игру");
        resumeGameButton.setVisible(false);
        JButton pausedGameButton = new JButton("Остановить игру игру");
        pausedGameButton.setVisible(false);
        JButton settingsGameButton = new JButton("Настройки");
        settingsGameButton.setVisible(false);
        JButton loadGameButton = new JButton("Загрузить игру");
        loadGameButton.setVisible(false);
        JButton saveGameButton = new JButton("Сохранить игру");
        saveGameButton.setVisible(false);
        JButton exitButton = new JButton("Выйти");
        exitButton.setVisible(false);

        menuPanel.add(menuButton, BorderLayout.NORTH);
        menuPanel.add(newGameButton);
        menuPanel.add(resumeGameButton);
        menuPanel.add(pausedGameButton);
        menuPanel.add(settingsGameButton);
        menuPanel.add(loadGameButton);
        menuPanel.add(saveGameButton);
        menuPanel.add(exitButton);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameButton.setVisible(!newGameButton.isVisible());
                resumeGameButton.setVisible(!resumeGameButton.isVisible());
                pausedGameButton.setVisible(!pausedGameButton.isVisible());
                settingsGameButton.setVisible(!settingsGameButton.isVisible());
                loadGameButton.setVisible(!loadGameButton.isVisible());
                saveGameButton.setVisible(!saveGameButton.isVisible());
                exitButton.setVisible(!exitButton.isVisible());
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.startNewGame();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        resumeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.resumeGame();
                    getContentPane().getComponent(0).requestFocus();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        pausedGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pauseGame();
            }
        });
        settingsGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.settings.settingsFrame = new SettingsFrame(game.settings);
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.loadFromFile();
                    getContentPane().getComponent(0).requestFocus();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        saveGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.saveInFile();
                } catch (InterruptedException | NoSuchFieldException | IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(menuPanel, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        getContentPane().setBackground(Color.blue);
        setVisible(true);
    }

    public DisplayObjects getDisplayFigures() {
        return displayObjects;
    }

    public void setDisplayFigures(DisplayObjects displayObjects) {
        this.displayObjects = displayObjects;
    }
}
