package ru.mishapan.shapes;

public class IsoscelesTriangle {

    private static final int N = 6;
    private double[] coordinates = new double[N];
    private double[] sides;

    public IsoscelesTriangle(double[] coordinates) {
        setCoordinates(coordinates);
    }


    private void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
        try {
            calculateSides(coordinates);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setSides(double[] sides) {
        this.sides = sides;
    }

    private double getSideA() {
        return 0;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    private boolean checkSides(double[] sides) {

        if (sides.length != 3){
            return false;
        }
        return (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]);
    }

    private void calculateSides(double[] coordinates) throws Exception {

        if (coordinates.length != 6) {
            throw new Exception("Quantity coordinates error!");
        }

        double[] sides = new double[3];
        sides[0] = Math.sqrt(Math.pow(coordinates[0] - coordinates[2], 2) + Math.pow(coordinates[1] - coordinates[3], 2));
        sides[1] = Math.sqrt(Math.pow(coordinates[0] - coordinates[4], 2) + Math.pow(coordinates[1] - coordinates[5], 2));
        sides[2] = Math.sqrt(Math.pow(coordinates[2] - coordinates[4], 2) + Math.pow(coordinates[3] - coordinates[5], 2));

        setSides(sides);

        if (!checkSides(sides)) {
            throw new Exception("Triangle are not isosceles!");
        }

    }

    public double getSquare() {
        SquareFinder sq = new TriangleSquareFinder();
        return sq.findSquare(sides);
    }

    public static void main(String[] args) {

        double[] coord = {0, 0, 4, 2, 8, 0};
        IsoscelesTriangle it = new IsoscelesTriangle(coord);

        System.out.println(it.getSquare());
    }
}
