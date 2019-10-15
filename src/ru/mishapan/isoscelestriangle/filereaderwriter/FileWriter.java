package ru.mishapan.isoscelestriangle.filereaderwriter;

import ru.mishapan.isoscelestriangle.IsoscelesTriangle;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Writes strings to file
 */
public class FileWriter {

    /**
     * Writes coordinates of objects of IsoscelesTriangle class from list to file
     *
     * @param path path of the output text file
     * @param list list that contains objects of IsoscelesTriangle
     */
    public void write(String path, List<IsoscelesTriangle> list) {

        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(path))) {

            System.out.println(" > Writing to file at " + LocalDateTime.now() + "...");

            for (IsoscelesTriangle triangle : list) {
                bw.write(triangle.toString());
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(" > Write to file is over at " + LocalDateTime.now());
        System.out.println(" > Written " + list.size() + " lines");
        System.out.println(" > Check incorrect lines in logs.txt");
    }
}
