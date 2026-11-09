package astra.physics.force;

import astra.physics.body.Body;
import astra.physics.math.Vector2D;

public class GravitationalForce {

    private final double gravitationalConstant;

    public GravitationalForce(double gravitationalConstant) {
        if (gravitationalConstant < 0) {
            throw new IllegalArgumentException(
                "Gravitational constant cannot be negative."
            );
        }
        this.gravitationalConstant = gravitationalConstant;
    }

    public void apply(Body bodyA, Body bodyB) {

        // Direction from A to B
        Vector2D direction = bodyB.getMotionState()
                .getPosition()
                .subtract(bodyA.getMotionState().getPosition());

        // Distance between the bodies
        double distance = direction.magnitude();

        // Avoid division by zero
        if (distance == 0) {
            return;
        }

        // Newton's law of universal gravitation
        double forceMagnitude = gravitationalConstant
                * bodyA.getMass()
                * bodyB.getMass()
                / (distance * distance);

        // Convert magnitude into a directional vector
        Vector2D unitDirection = direction.normalize();
        Vector2D force = unitDirection.multiply(forceMagnitude);

        // Newton's third law: equal and opposite forces
        bodyA.getMotionState().applyForce(force);
        bodyB.getMotionState().applyForce(force.multiply(-1));
    }
}
