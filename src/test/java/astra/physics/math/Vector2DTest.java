package astra.physics.math;

public class Vector2DTest {

    public static void main(String[] args) {

        Vector2D a = new Vector2D(3, 4);
        Vector2D b = new Vector2D(2, 3);

        // Addition
        check(a.add(b), 5, 7, "Addition");

        // Subtraction
        check(a.subtract(b), 1, 1, "Subtraction");

        // Scalar multiplication
        check(a.multiply(2), 6, 8, "Multiplication");

        // Magnitude
        check(a.magnitude(), 5, "Magnitude");

        // Normalization
        check(a.normalize(), 0.6, 0.8, "Normalization");

        // Dot product
        check(a.dot(b), 18, "Dot product");

        // Distance
        check(a.distanceTo(b), Math.sqrt(2), "Distance");

        // Zero vector normalization
        check(new Vector2D(0, 0).normalize(), 0, 0, "Zero normalization");

        System.out.println("\nAll tests passed!");
    }

    private static void check(
            Vector2D actual,
            double expectedX,
            double expectedY,
            String testName) {

        if (Math.abs(actual.getX() - expectedX) > 0.000001 ||
            Math.abs(actual.getY() - expectedY) > 0.000001) {
            throw new AssertionError(testName + " failed");
        }

        System.out.println(testName + " passed");
    }

    private static void check(
            double actual,
            double expected,
            String testName) {

        if (Math.abs(actual - expected) > 0.000001) {
            throw new AssertionError(testName + " failed");
        }

        System.out.println(testName + " passed");
    }
}