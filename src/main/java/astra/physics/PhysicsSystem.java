
package astra.physics;

import java.util.List;

import astra.physics.body.Body;
import astra.physics.force.GravitationalForce;
import astra.physics.world.PhysicsWorld;

public class PhysicsSystem {

    private final GravitationalForce gravitationalForce =
            new GravitationalForce(100);

    public void update(PhysicsWorld world, double deltaTime) {

        List<Body> bodies = world.getBodies();

        // 1. Clear previous forces
        for (Body body : bodies) {
            body.getMotionState().clearForces();
        }

        // 2. Calculate gravitational interactions
        for (int i = 0; i < bodies.size(); i++) {
            for (int j = i + 1; j < bodies.size(); j++) {
                gravitationalForce.apply(
                    bodies.get(i),
                    bodies.get(j)
                );
            }
        }

        // 3. Calculate acceleration
        for (Body body : bodies) {
            body.getMotionState()
                    .calculateAcceleration(body.getMass());
        }

        // 4. Update velocity
        for (Body body : bodies) {
            body.getMotionState().updateVelocity(deltaTime);
        }

        // 5. Update position
        for (Body body : bodies) {
            body.getMotionState().updatePosition(deltaTime);
        }
    }
}
