package astra.physics.math;

public class Vector2D {

    private final double x;
    private final double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(x + other.x, y + other.y);
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(x - other.x, y - other.y);
    }

    public Vector2D multiply(double scalar) {
        return new Vector2D(x * scalar, y * scalar);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D normalize() {
        double magnitude = magnitude();

        if (magnitude == 0) {
            return new Vector2D(0, 0);
        }

        return new Vector2D(x / magnitude, y / magnitude);
    }

    public double dot(Vector2D other) {
        return x * other.x + y * other.y;
    }

    public double distanceTo(Vector2D other) {
        return subtract(other).magnitude();
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
