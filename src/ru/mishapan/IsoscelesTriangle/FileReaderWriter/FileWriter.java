package ru.mishapan.IsoscelesTriangle.FileReaderWriter;

import ru.mishapan.IsoscelesTriangle.IsoscelesTriangle;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FileWriter {

    public void write(String fileName, List<IsoscelesTriangle> list) {

        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(fileName))) {
            for (IsoscelesTriangle triangle : list) {
                bw.write(triangle.toString());
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
