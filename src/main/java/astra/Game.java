package astra;

import javax.swing.JFrame;
import astra.graphics.GamePanel;

public class Game {

    private boolean running;
    private final JFrame window;
    private final GamePanel gamePanel;
    private final Time time;
    private final Thread gameThread;

    public Game() {

        window = new JFrame("astra");
        gamePanel = new GamePanel();
        time = new Time();

        gameThread = new Thread(this::run);

        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(gamePanel);
    }

    private void run() {
        while(running) {
                time.update();

                while(time.shouldUpdatePhysics()) {
                    update();
                    time.consumePhysicsStep();
                }

                render();

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
    }

    public void start() {
        window.setVisible(true);

        running = true;
        gameThread.start();
    }

    public void stop() {
        running = false;
    }

    public void update() {
        // update simulation
    }

    public void render() {
        gamePanel.repaint();
    }

}
