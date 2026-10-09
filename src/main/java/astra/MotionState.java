package astra;

public class MotionState {
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;

    public MotionState(double positionX,  double positionY, double velocityX, double velocityY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }
    
    public double getPositionX() {
        return positionX;
    }
    public double getPositionY() {
        return positionY;
    }
    public double getVelocityX() {
        return velocityX;
    }
    public double getVelocityY() {
        return velocityY;
    }
    
    public void updatePosition(double deltaTime) {
        positionX += velocityX * deltaTime;
        positionY += velocityY * deltaTime;
    }

    public void setVelocityX(double velocityX, double velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }
}
