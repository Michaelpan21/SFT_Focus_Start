package ru.mishapan.IsoscelesTriangle.FileReaderWriter;

import ru.mishapan.IsoscelesTriangle.IsoscelesTriangle;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class FileWriter {

    public void write(String path, List<IsoscelesTriangle> list) {

        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(path))) {

            System.out.println(" > Writing to file at " + new Date() + "...");

            for (IsoscelesTriangle triangle : list) {
                bw.write(triangle.toString());
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(" > Write to file is over at " + new Date());
        System.out.println(" > Written " + list.size() + " lines");
        System.out.println(" > Check incorrect lines in logs.txt");
    }
}
