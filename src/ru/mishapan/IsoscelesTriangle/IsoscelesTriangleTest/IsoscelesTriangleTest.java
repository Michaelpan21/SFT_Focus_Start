package ru.mishapan.IsoscelesTriangle.IsoscelesTriangleTest;

        import ru.mishapan.IsoscelesTriangle.CoordinatesTransfer;
        import ru.mishapan.IsoscelesTriangle.IsoscelesTriangle;

public class IsoscelesTriangleTest {
    public static void main(String[] args) {

        double[] coordinates = {0, 0, 4, 8, 8, 0};

        try {
            double[] sides = CoordinatesTransfer.toLength(coordinates);
            IsoscelesTriangle triangle = new IsoscelesTriangle(sides[0], sides[1], sides[2]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
