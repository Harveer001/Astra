package astra.physics.body;

import astra.physics.math.Vector2D;

public class MotionState {

    private Vector2D position;
    private Vector2D velocity;
    private Vector2D acceleration;
    private Vector2D accumulatedForce;

    public MotionState(
            Vector2D position,
            Vector2D velocity) {

        this.position = position;
        this.velocity = velocity;
        this.acceleration = new Vector2D(0, 0);
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public Vector2D getAcceleration() {
        return acceleration;
    }

    public void updatePosition(double deltaTime) {
        position = position.add(velocity.multiply(deltaTime));
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public void setAcceleration(Vector2D acceleration) {
        this.acceleration = acceleration;
    }

    public void updateVelocity(double deltaTime) {
        velocity = velocity.add(
            acceleration.multiply(deltaTime)
        );
    }


    public void applyForce(Vector2D force) {
        accumulatedForce = accumulatedForce.add(force);
    }

    public void calculateAcceleration(double mass) {
        if(mass <= 0) {
            throw new IllegalArgumentException("Mass must be positive.");
        }

        acceleration = accumulatedForce.multiply(1.0 / mass);
    }

    public void clearForces() {
        accumulatedForce = new Vector2D(0, 0);
    }

}