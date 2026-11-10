
package astra.physics.collision;

import java.util.ArrayList;
import java.util.List;
import astra.physics.world.PhysicsWorld;
import astra.physics.body.Body;
import astra.physics.math.Vector2D;

public class CollisionDetector {

    public boolean isColliding(Body bodyA, Body bodyB) {

        Vector2D positionA = bodyA.getMotionState().getPosition();
        Vector2D positionB = bodyB.getMotionState().getPosition();

        double dx = positionB.getX() - positionA.getX();
        double dy = positionB.getY() - positionA.getY();

        double distanceSquared = dx * dx + dy * dy;

        double radiusSum = bodyA.getRadius() + bodyB.getRadius();

        return distanceSquared <= radiusSum * radiusSum;
    }

    public Collision detect(Body bodyA, Body bodyB) {
        Vector2D positionA = bodyA.getMotionState().getPosition();
        Vector2D positionB = bodyB.getMotionState().getPosition();

        double dx = positionB.getX() - positionA.getX();
        double dy = positionB.getY() - positionA.getY();

        double distanceSquared = dx * dx + dy * dy;
        double radiusSum = bodyA.getRadius() + bodyB.getRadius();

        if(!(distanceSquared <= radiusSum * radiusSum)) {
            return null;
        }

        double distance = Math.sqrt(distanceSquared);

        Vector2D normal;

        if (distance == 0) {
            normal = new Vector2D(1, 0);
        } else {
            normal = new Vector2D(dx / distance, dy / distance);
        }

        double penetration = radiusSum - distance;

        return new Collision(bodyA, bodyB, normal, penetration);
        
    }

    public List<Collision> detectAll(PhysicsWorld world) {
        List<Collision> collisions = new ArrayList<>();
        List<Body> bodies = world.getBodies();

        for (int i = 0; i < bodies.size(); i++) {
            for (int j = i + 1; j < bodies.size(); j++) {
                Collision collision = detect( bodies.get(i), bodies.get(j));

                if (collision != null) {
                    collisions.add(collision);
                }
            }
        }

        return collisions;
    }
}
