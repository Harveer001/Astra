package astra.core;

public class Time {
    public static final double PHYSICS_UPDATES_PER_SECOND = 60.0;
    public static final double FIXED_DELTA_TIME = 1.0 / PHYSICS_UPDATES_PER_SECOND;

    private double accumulator;
    private long lastTime;

    public Time() {
        lastTime = System.nanoTime();
    }

    public void update() {
        long currentTime = System.nanoTime();
        long elapsedNanoseconds = currentTime - lastTime;
        lastTime = currentTime;
        double elapsedSeconds = elapsedNanoseconds/1_000_000_000.0;
        accumulator += elapsedSeconds;
    }

    public boolean shouldUpdatePhysics() {
        return accumulator >= FIXED_DELTA_TIME;
    }

    public void consumePhysicsStep() {
        accumulator -= FIXED_DELTA_TIME;
    }
}
