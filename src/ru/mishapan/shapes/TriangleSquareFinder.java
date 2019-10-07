package ru.mishapan.shapes;

public class TriangleSquareFinder implements SquareFinder{
    @Override
    public double findSquare(double[] sides) {
        if(sides.length != 3){
            System.out.println("Error in " + getClass());
            return 0;
        }

        return 0.25 * Math.sqrt((sides[0] + sides[1] - sides[2]) * (sides[0] - sides[1] + sides[2]) *
                (-sides[0] + sides[1] + sides[2]) * (sides[0] + sides[1] + sides[2]));
    }
}
