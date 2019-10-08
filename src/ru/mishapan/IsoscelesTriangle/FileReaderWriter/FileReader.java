package ru.mishapan.IsoscelesTriangle.FileReaderWriter;

import ru.mishapan.IsoscelesTriangle.IsoscelesTriangle;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

    public void read(String path) {
        try (BufferedReader bf = new BufferedReader(new java.io.FileReader(path))) {
            String fileLine;

            while ((fileLine = bf.readLine()) != null) {

                double[] coordinates = new double[6];

                int i = 0;
                for (String str : fileLine.split(" ")) {
                    coordinates[i] = Double.parseDouble(str);
                    i++;
                }

                try {
                    new IsoscelesTriangle(coordinates).getSquare();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
