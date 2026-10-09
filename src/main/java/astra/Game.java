package astra;

import javax.swing.JFrame;
import astra.graphics.GamePanel;

public class Game {

    private volatile boolean running;
    private final JFrame window;
    private final GamePanel gamePanel;
    private final Time time;
    private final Thread gameThread;
    private final MotionState earthMotion = new MotionState(0, 0, 100, 50);
    private final Body earth = new Body(1000, 20, earthMotion);
    private final PhysicsSystem physicsSystem = new PhysicsSystem();

    public Game() {

        window = new JFrame("astra");
        gamePanel = new GamePanel(earth);
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
                break;
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
        physicsSystem.update(earth, Time.FIXED_DELTA_TIME);
    }

    public void render() {
        gamePanel.repaint();
    }

}
