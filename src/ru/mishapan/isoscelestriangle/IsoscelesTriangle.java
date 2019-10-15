package ru.mishapan.isoscelestriangle;

/**
 * Contains side, base and coordinates if isosceles triangle
 * Checks if triangle is isosceles
 * Calculates area
 */
public class IsoscelesTriangle {

    private double side;
    private double base;
    private double[] coordinates;

    /**
     * Transfers coordinates to sides
     * Checks if triangle is isosceles transfer sides to side and base.
     *
     * @param coordinates array of doubles contains coordinates of triangle. Array length must be six or throws
     *                    exception
     */
    public IsoscelesTriangle(double[] coordinates) {

        if (coordinates.length != 6) {
            throw new IllegalArgumentException("Quantity of coordinates are not six");
        }

        setCoordinates(coordinates);
        double[] sides = CoordinatesTransfer.toLength(coordinates);

        if (!checkIsosceles(sides[0], sides[1], sides[2])) {
            throw new IllegalArgumentException("Triangle are not isosceles");
        }

        if (sides[0] == sides[1]) {
            setBase(sides[2]);
            setSide(sides[0]);
        } else {
            setSide(sides[2]);

            if (sides[2] == sides[0]) {
                setBase(sides[1]);
            } else {
                setBase(sides[0]);
            }
        }
    }

    private void setBase(double base) {
        this.base = base;
    }

    private void setSide(double side) {
        this.side = side;
    }

    private void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double getBase() {
        return base;
    }

    public double getSide() {
        return side;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    /**
     * Checks Isosceles of triangle
     *
     * @param a side a
     * @param b side b
     * @param c side c
     * @return true if triangle is isosceles
     */
    private boolean checkIsosceles(double a, double b, double c) {

        return (a == b || b == c || a == c);
    }

    /**
     * Calculates area of isosceles triangle if side and base are known
     *
     * @return area of isosceles triangle
     */
    public double getArea() {

        return 0.25 * base * Math.sqrt(4 * Math.pow(side, 2) - Math.pow(base, 2));
    }

    /**
     * @return coordinates of triangle as string
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (double i : getCoordinates()) {
            sb.append(i);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.toString().length() - 1);

        return sb.toString();
    }
}
