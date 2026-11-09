package astra.physics.body;

public class Body {
    private double mass;
    private double radius;
    private MotionState motionState;

    public Body(double mass, double radius, MotionState motionState) {
        this.mass = mass;
        this.radius = radius;
        this.motionState = motionState;
    }

    public double getMass() {
        return mass;
    }
    public double getRadius() {
        return radius;
    }
    public MotionState getMotionState() {
        return motionState;
    }
    
}
