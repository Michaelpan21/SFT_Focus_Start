package ru.mishapan.IsoscelesTriangle;

public class IsoscelesTriangle {

    private double side;
    private double base;

    public IsoscelesTriangle(double a, double b, double c) throws Exception {

        if (!checkIsosceles(a, b, c)) {
            throw new Exception("Triangle are not isosceles!");
        }

        if (a == b) {
            setBase(c);
            setSide(a);
        } else {
            setSide(c);

            if (c == a) {
                setBase(b);
            } else {
                setBase(a);
            }
        }
    }

    private void setBase(double base) {
        this.base = base;
    }

    private void setSide(double side) {
        this.side = side;
    }

    public double getBase() {
        return base;
    }

    public double getSide() {
        return side;
    }

    private boolean checkIsosceles(double a, double b, double c) {

        return (a == b || b == c || a == c);
    }


    public double getSquare() {

        return 0.25 * base * Math.sqrt(4 * Math.pow(side, 2) - Math.pow(base, 2));
    }

}
