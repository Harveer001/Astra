package astra.visualization;

import javax.swing.JPanel;
import java.awt.Graphics;
import astra.physics.math.Vector2D;
import astra.physics.body.Body;
import astra.physics.world.PhysicsWorld;


public class GamePanel extends JPanel {

    private final PhysicsWorld world;

    public GamePanel(PhysicsWorld world) {
        this.world = world;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Body body : world.getBodies()) {
            Vector2D position = body.getMotionState().getPosition();

            int width = getWidth();
            int height = getHeight();

            int screenX = (int) (position.getX() + width / 2.0);
            int screenY = (int) (height / 2.0 - position.getY());
            
            int radius = (int) body.getRadius();

            g.fillOval(
                screenX - radius,
                screenY - radius,
                radius * 2,
                radius * 2
            );
        }
    }
}