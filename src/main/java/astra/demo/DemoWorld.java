
package astra.demo;

import astra.physics.body.Body;
import astra.physics.body.MotionState;
import astra.physics.math.Vector2D;
import astra.physics.world.PhysicsWorld;

public class DemoWorld {

    public static PhysicsWorld create() {

        PhysicsWorld world = new PhysicsWorld();

        // object1
        MotionState object1Motion = new MotionState(
            new Vector2D(-100, 0),
            new Vector2D(100, 0)
        );
        Body object1 = new Body(10000, 15, object1Motion);

        // object2
        MotionState object2Motion = new MotionState(
            new Vector2D(100, 0),
            new Vector2D(-100, 0)
        );
        Body object2 = new Body(5000, 10, object2Motion);

        // Add bodies to the world
        world.addBody(object1);
        world.addBody(object2);

        return world;
    }
}
