package sim3dwater.graphics;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(100, 100, 50, 50);
    }
}