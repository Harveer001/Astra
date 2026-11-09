package astra.physics.force;

import astra.physics.body.Body;
import astra.physics.math.Vector2D;

public class Gravity {

    private final Vector2D gravity;

    public Gravity() {
        this.gravity = new Vector2D(0, -9.81);
    }

    public void apply(Body body) {
        Vector2D gravityForce = gravity.multiply(body.getMass());

        body.getMotionState().applyForce(gravityForce);
    }
}