
package astra.physics.collision;

import astra.physics.body.Body;
import astra.physics.body.MotionState;
import astra.physics.math.Vector2D;

public class CollisionDetectorTest {

    public static void main(String[] args) {

        MotionState motionA = new MotionState(
            new Vector2D(0, 0),
            new Vector2D(2, 0)
        );
        Body bodyA = new Body(10, 5, motionA);

        MotionState motionB = new MotionState(
            new Vector2D(8, 0),
            new Vector2D(-2, 0)
        );
        Body bodyB = new Body(10, 5, motionB);

        CollisionDetector detector = new CollisionDetector();

        Collision collision = detector.detect(bodyA, bodyB);

        CollisionResolver resolver = new CollisionResolver();
        resolver.resolve(collision);

        System.out.println("A velocity: " + bodyA.getMotionState().getVelocity());

        System.out.println("B velocity: " + bodyB.getMotionState().getVelocity());

        System.out.println("A position: " + bodyA.getMotionState().getPosition());

        System.out.println("B position: " + bodyB.getMotionState().getPosition());

    }
}
