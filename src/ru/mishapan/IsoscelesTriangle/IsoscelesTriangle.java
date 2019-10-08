package ru.mishapan.IsoscelesTriangle;

public class IsoscelesTriangle {

    private double side;
    private double base;
    private double[] coordinates;

    public IsoscelesTriangle(double[] coordinates) throws Exception {

        if (coordinates.length != 6) {
            throw new Exception("Quantity of coordinates are not six");
        }

        setCoordinates(coordinates);
        double[] sides = CoordinatesTransfer.toLength(coordinates);

        if (!checkIsosceles(sides[0], sides[1], sides[2])) {
            throw new Exception("Triangle are not isosceles");
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

    private boolean checkIsosceles(double a, double b, double c) {

        return (a == b || b == c || a == c);
    }

    public double getSquare() {

        return 0.25 * base * Math.sqrt(4 * Math.pow(side, 2) - Math.pow(base, 2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double i : coordinates){
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }
}
