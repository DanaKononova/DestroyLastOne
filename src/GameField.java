import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameField extends JFrame {
    DisplayObjects displayObjects;
    GameStatistic gameStatistic;
    int background;
    GameMessageBox gameMessageBox;
    Game game;
    int width;
    int height;
    double sizeKoeff = 1;
    boolean flag = true;
    int progressValue = 0;
    JProgressBar progressBar;
    JButton button;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;

    public GameField(Game game, int width, int height) throws InterruptedException {
        this.game = game;
        this.width = width;
        this.height = height;

        switch (width) {
            case 1200 -> {
                sizeKoeff = 1;
                setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
            case 1000 -> {
                sizeKoeff = 0.7;
            }
            case 900 -> {
                sizeKoeff = 0.65;
            }
            case 800 -> {
                sizeKoeff = 0.56;
            }
            case 700 ->{
                sizeKoeff = 0.52;
            }
        }

        setTitle("Destroy Last One");
        //Menu
        JPanel menuPanel = new JPanel(new GridLayout(8, 1, 0, 5));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20)); // добавляем отступы в 10 пикселей сверху, снизу, слева и справа
        JButton resumeGameButton = new JButton("Продолжить игру");
        resumeGameButton.setVisible(false);
        JButton pausedGameButton = new JButton("Остановить игру");
        pausedGameButton.setVisible(false);
        JButton settingsGameButton = new JButton("Настройки");
        settingsGameButton.setVisible(false);
        JButton loadGameButton = new JButton("Загрузить игру");
        loadGameButton.setVisible(false);
        JButton saveGameButton = new JButton("Сохранить игру");
        saveGameButton.setVisible(false);
        JButton exitButton = new JButton("Выйти");
        exitButton.setVisible(false);

        menuPanel.add(resumeGameButton);
        menuPanel.add(pausedGameButton);
        menuPanel.add(settingsGameButton);
        menuPanel.add(loadGameButton);
        menuPanel.add(saveGameButton);
        menuPanel.add(exitButton);
        resumeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.resumeGame();
                    resumeGameButton.setVisible(!resumeGameButton.isVisible());
                    pausedGameButton.setVisible(!pausedGameButton.isVisible());
                    settingsGameButton.setVisible(!settingsGameButton.isVisible());
                    loadGameButton.setVisible(!loadGameButton.isVisible());
                    saveGameButton.setVisible(!saveGameButton.isVisible());
                    exitButton.setVisible(!exitButton.isVisible());
                    getContentPane().getComponent(1).requestFocus();
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
                try {
                    game.settingsGame();
                    getContentPane().getComponent(1).requestFocus();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.loadFromFile();
                    setNullStatusBar();
                    updateStatusBar();
                    //  game.resumeGame();
                    getContentPane().getComponent(1).requestFocus();
//                    Runnable myRunnable = new Runnable() {
//                        @Override
//                        public void run() {
//                            long time = System.currentTimeMillis();
//                            while (System.currentTimeMillis() < time + 10) {
//                            }
//                            Game.timer.stop();
//                        }
//                    };
//
//                    Thread thread = new Thread(myRunnable);
//                    thread.start();
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
                Game.timer.stop();
                System.exit(0);
            }
        });

        //ProgressBar
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setValue(0);
        button = new JButton("Menu");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resumeGameButton.setVisible(!resumeGameButton.isVisible());
                pausedGameButton.setVisible(!pausedGameButton.isVisible());
                settingsGameButton.setVisible(!settingsGameButton.isVisible());
                loadGameButton.setVisible(!loadGameButton.isVisible());
                saveGameButton.setVisible(!saveGameButton.isVisible());
                exitButton.setVisible(!exitButton.isVisible());
                if (resumeGameButton.isVisible()) {
                    game.pauseGame();
                }
            }
        });

        textField1 = new JTextField();
        textField1.setEditable(false);
        game.statusBar.setName("Dana");
        textField1.setText("Name: "+game.statusBar.getName());
        textField2 = new JTextField();
        textField2.setEditable(false);
        game.statusBar.setSurname("Kononova");
        textField2.setText("Surname: "+game.statusBar.getSurname());
        textField3 = new JTextField();
        textField3.setEditable(false);
        game.statusBar.setDestroyed("0");
        textField3.setText("Destroyed: "+game.statusBar.getDestroyed());
        textField4 = new JTextField();
        textField4.setEditable(false);
        game.statusBar.setTime("00:00");
        textField4.setText("Time: "+game.statusBar.getTime());
        Font font = new Font(textField1.getFont().getName(), Font.PLAIN, (int)(14*sizeKoeff));
        textField1.setFont(font);
        font = new Font(textField2.getFont().getName(), Font.PLAIN, (int)(14*sizeKoeff));
        textField2.setFont(font);
        font = new Font(textField3.getFont().getName(), Font.PLAIN, (int)(14*sizeKoeff));
        textField3.setFont(font);
        font = new Font(textField4.getFont().getName(), Font.PLAIN, (int)(14*sizeKoeff));
        textField4.setFont(font);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(progressBar);
        panel.add(Box.createHorizontalStrut((int)(30 * sizeKoeff)));
        panel.add(textField1);
        panel.add(Box.createHorizontalStrut((int)(30*sizeKoeff)));
        panel.add(textField2);
        panel.add(Box.createHorizontalStrut((int)(30*sizeKoeff)));
        panel.add(textField3);
        panel.add(Box.createHorizontalStrut((int)(30*sizeKoeff)));
        panel.add(textField4);
        panel.add(Box.createHorizontalStrut((int)(30*sizeKoeff)));
        panel.add(button);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);

        //Objects
        displayObjects = new DisplayObjects(width, height, sizeKoeff);
        getContentPane().add(displayObjects);

        menuPanel.setBackground(new Color(238, 202, 229));
        getContentPane().add(menuPanel, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().getComponent(1).requestFocus();
        setSize(width, height);
        setVisible(true);
    }

    void setProgressValue() {
        progressValue += 2;
        game.statusBar.setProgressBar(Integer.toString(progressValue));
        progressBar.setValue(Integer.parseInt(game.statusBar.getProgressBar()));
        game.statusBar.setDestroyed(Integer.toString(progressValue / 2));
        textField3.setText("Destroyed: " + Integer.parseInt(game.statusBar.getProgressBar()) / 2);
    }

    void formatTime(long elapsedTime) {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        Date date = new Date(elapsedTime);
        String time = format.format(date);
        game.statusBar.setTime(time);
        textField4.setText("Time: " + game.statusBar.getTime());
    }

    public void close() {
        getContentPane().removeAll();
        setVisible(false);
        flag = true;
    }

    public void updateStatusBar(){
        textField1.setText("Name: "+game.statusBar.getName());
        textField2.setText("Surname: "+game.statusBar.getSurname());
        textField3.setText("Destroyed: " + Integer.parseInt(game.statusBar.getProgressBar()) / 2);
        progressBar.setValue(Integer.parseInt(game.statusBar.getProgressBar()));
        textField4.setText("Time: " + game.statusBar.getTime());
    }
    public void setNullStatusBar(){
        textField3.setText("Destroyed: 0");
        progressBar.setValue(0);
        textField4.setText("Time: 00:00");
    }
    public DisplayObjects getDisplayFigures() {
        return displayObjects;
    }

    public void setDisplayFigures(DisplayObjects displayObjects) {
        this.displayObjects = displayObjects;
    }
}
