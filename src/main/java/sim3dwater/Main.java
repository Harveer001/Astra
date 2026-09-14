package sim3dwater;

import javax.swing.JFrame;

import sim3dwater.graphics.GamePanel;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame("Sim3dWater");
        GamePanel gamePanel = new GamePanel();

        window.setSize(800, 600);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(gamePanel);
        window.setVisible(true);

    }
}