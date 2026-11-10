package astra.physics.collision;

import astra.physics.body.Body;
import astra.physics.math.Vector2D;

public class Collision {
    private final Body bodyA;
    private final Body bodyB;
    private final Vector2D normal;
    private final double penetration;

    public Collision(Body bodyA, Body bodyB, Vector2D normal, double penetration) {
        this.bodyA = bodyA;
        this.bodyB = bodyB;
        this.normal = normal;
        this.penetration = penetration;
    }

    public Body getBodyA() {
        return bodyA;
    }

    public Body getBodyB() {
        return bodyB;
    }

    public Vector2D getNormal() {
        return normal;
    }

    public double getPenetration() {
        return penetration;
    }
}