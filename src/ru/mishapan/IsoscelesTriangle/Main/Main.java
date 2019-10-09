package ru.mishapan.IsoscelesTriangle.Main;

import ru.mishapan.IsoscelesTriangle.FileReaderWriter.FileReader;
import ru.mishapan.IsoscelesTriangle.FileReaderWriter.FileWriter;


public class Main {
    public static void main(String[] args) {

        FileReader fileIn = new FileReader();
        fileIn.readAndSave("input.txt");

        FileWriter fileOut = new FileWriter();
        fileOut.write("output.txt", fileIn.getList());
    }
}
