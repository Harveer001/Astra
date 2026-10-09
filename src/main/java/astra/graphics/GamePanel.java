package astra.graphics;

import javax.swing.JPanel;
import java.awt.Graphics;
import astra.Body;
import astra.MotionState;

public class GamePanel extends JPanel {

    private final Body body;
    public GamePanel(Body body) {
        this.body = body;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        MotionState motion = body.getMotionState();

        int width = getWidth();
        int height = getHeight();
        int screenX = (int) (motion.getPositionX() + width / 2.0);
        int screenY = (int) (height / 2.0 - motion.getPositionY());
        int radius = (int) body.getRadius();

        g.fillOval(
            screenX - radius,
            screenY - radius,
            radius * 2,
            radius * 2
        );
    }
}