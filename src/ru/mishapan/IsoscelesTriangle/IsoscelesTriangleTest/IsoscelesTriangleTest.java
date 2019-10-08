package ru.mishapan.IsoscelesTriangle.IsoscelesTriangleTest;

import ru.mishapan.IsoscelesTriangle.FileReaderWriter.FileReader;

public class IsoscelesTriangleTest {
    public static void main(String[] args) {

        double[] coordinates = {0, 0, 4, 8, 8, 0};

        FileReader fileReader = new FileReader();
        fileReader.read("input.txt");

    }
}
