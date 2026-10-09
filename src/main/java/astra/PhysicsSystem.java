package astra;

public class PhysicsSystem{
    public void update(Body body, double deltaTime) {
        body.getMotionState().updatePosition(deltaTime);
    }
}
