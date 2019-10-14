package ru.mishapan.IsoscelesTriangle;

/**
 * Transfer coordinates
 */
public class CoordinatesTransfer {

    /**
     * Transfers coordinates to triangle sides
     *
     * @param coordinates two-dimensional coordinates of triangle
     * @return array of doubles that contains sides's lengths
     */
    public static double[] toLength(double[] coordinates) {

        if (coordinates.length != 6) {
            throw new IllegalArgumentException("Quantity of coordinates are not six");
        }

        double[] sides = new double[3];
        sides[0] = Math.sqrt(Math.pow(coordinates[0] - coordinates[2], 2)
                + Math.pow(coordinates[1] - coordinates[3], 2));
        sides[1] = Math.sqrt(Math.pow(coordinates[0] - coordinates[4], 2)
                + Math.pow(coordinates[1] - coordinates[5], 2));
        sides[2] = Math.sqrt(Math.pow(coordinates[2] - coordinates[4], 2)
                + Math.pow(coordinates[3] - coordinates[5], 2));

        return sides;
    }
}
