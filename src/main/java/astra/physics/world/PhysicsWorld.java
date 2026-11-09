package astra.physics.world;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import astra.physics.body.Body;

public class PhysicsWorld {
    private List<Body> bodies = new ArrayList<>();

    public void addBody(Body body) {
        bodies.add(body);
    }

    public List<Body> getBodies() {
        return Collections.unmodifiableList(bodies);
    }
}