package ru.mishapan.IsoscelesTriangle.IsoscelesTriangleTest;

import ru.mishapan.IsoscelesTriangle.FileReaderWriter.FileReader;
import ru.mishapan.IsoscelesTriangle.IsoscelesTriangle;


public class IsoscelesTriangleTest {
    public static void main(String[] args) {

        FileReader fileIn = new FileReader();
        fileIn.readAndSave("input.txt");

        for(IsoscelesTriangle triangle : fileIn.getList()){
            System.out.println("C: " + triangle.toString() + " Sq: " + triangle.getSquare());
        }
    }
}
