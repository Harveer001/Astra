package astra.physics.collision;

import astra.physics.body.Body;
import astra.physics.math.Vector2D;

public class CollisionResolver {

    public void resolve(Collision collision) {

        Body bodyA = collision.getBodyA();
        Body bodyB = collision.getBodyB();

        Vector2D normal = collision.getNormal();

        Vector2D velocityA = bodyA.getMotionState().getVelocity();

        Vector2D velocityB = bodyB.getMotionState().getVelocity();

        Vector2D relativeVelocity = velocityB.subtract(velocityA);

        double velocityAlongNormal = relativeVelocity.dot(normal);

        // Ignore bodies that are already moving apart.
        if (velocityAlongNormal <= 0) {
            double inverseMassA = 1.0 / bodyA.getMass();
            double inverseMassB = 1.0 / bodyB.getMass();

            double impulseMagnitude = -2.0 * velocityAlongNormal / (inverseMassA + inverseMassB);

            Vector2D impulse = normal.multiply(impulseMagnitude);

            Vector2D newVelocityA = velocityA.subtract(impulse.multiply(inverseMassA));

            Vector2D newVelocityB = velocityB.add(impulse.multiply(inverseMassB));

            bodyA.getMotionState().setVelocity(newVelocityA);
            bodyB.getMotionState().setVelocity(newVelocityB);
        }
        
        correctPenetration(collision);
    }

    private void correctPenetration(Collision collision) {

        Body bodyA = collision.getBodyA();
        Body bodyB = collision.getBodyB();

        double inverseMassA = 1.0 / bodyA.getMass();
        double inverseMassB = 1.0 / bodyB.getMass();

        double slop = 0.01;
        double percent = 0.8;

        double correctionMagnitude =
            Math.max(collision.getPenetration() - slop, 0.0)
            / (inverseMassA + inverseMassB) * percent;

        Vector2D correction =
            collision.getNormal().multiply(correctionMagnitude);

        Vector2D positionA =
            bodyA.getMotionState().getPosition();

        Vector2D positionB =
            bodyB.getMotionState().getPosition();

        bodyA.getMotionState().setPosition(
            positionA.subtract(correction.multiply(inverseMassA))
        );

        bodyB.getMotionState().setPosition(
            positionB.add(correction.multiply(inverseMassB))
        );
    }
}