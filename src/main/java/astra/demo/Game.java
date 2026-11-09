package astra.demo;

import javax.swing.JFrame;

import astra.core.Time;
import astra.physics.body.Body;
import astra.visualization.GamePanel;
import astra.physics.body.MotionState;
import astra.physics.math.Vector2D;
import astra.physics.world.PhysicsWorld;
import astra.physics.PhysicsSystem;


public class Game {

    private volatile boolean running;
    private final JFrame window;
    private final GamePanel gamePanel;
    private final Time time;
    private final Thread gameThread;

    private final PhysicsWorld world = new PhysicsWorld();
    
    //Bodies
    private final MotionState earthMotion = new MotionState(
        new Vector2D(-75, 0),
        new Vector2D(0, 0)
    );
    private final Body earth = new Body(1000, 20, earthMotion);
    private final MotionState moonMotion = new MotionState(
        new Vector2D(50, 50),
        new Vector2D(4, 20)
    );
    private final Body moon = new Body(100, 5, moonMotion);

    private final PhysicsSystem physicsSystem = new PhysicsSystem();

    public Game() {
        world.addBody(earth);
        world.addBody(moon);

        window = new JFrame("astra");
        gamePanel = new GamePanel(world);
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
        physicsSystem.update(world, Time.FIXED_DELTA_TIME);
    }

    public void render() {
        gamePanel.repaint();
    }

}
