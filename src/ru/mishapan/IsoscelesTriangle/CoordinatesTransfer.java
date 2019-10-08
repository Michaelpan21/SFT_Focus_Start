package ru.mishapan.IsoscelesTriangle;

public class CoordinatesTransfer {

    public static double[] toLength(double[] coordinates) throws Exception{

        if (coordinates.length != 6) {
            throw new Exception("Quantity coordinates error!");
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
