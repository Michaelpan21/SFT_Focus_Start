package ru.mishapan.IsoscelesTriangle.FileReaderWriter;

import ru.mishapan.IsoscelesTriangle.IsoscelesTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class FileReader {

    private List<IsoscelesTriangle> list = new LinkedList<>();
    private Logger lg = new Logger();

    public void readAndSave(String path) {

        try (BufferedReader bf = new BufferedReader(new java.io.FileReader(path))) {

            System.out.println(" > Reading file at " + new Date() + "...");

            int counter = 0;
            String fileLine;

            while ((fileLine = bf.readLine()) != null) {
                counter++;
                try {
                    double[] coordinates = new double[6];

                    int i = 0;
                    for (String str : fileLine.split(" ")) {
                        coordinates[i] = Double.parseDouble(str);
                        i++;
                    }

                    IsoscelesTriangle triangle = new IsoscelesTriangle(coordinates);
                    saveIfTheLargest(triangle);
                } catch (Exception ex) {
                    lg.write(counter + "   " + ex.getMessage());
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(" > File read at " + new Date());

    }

    private void saveIfTheLargest(IsoscelesTriangle triangle) {

        if (triangle == null) {
            return;
        }

        if (list.size() == 0) {
            list.add(triangle);
            return;
        }

        if (triangle.getSquare() == list.get(0).getSquare() &&
                triangle.getCoordinates() != list.get(0).getCoordinates()) {
            list.add(triangle);
            return;
        }

        if (triangle.getSquare() > list.get(0).getSquare()) {
            list.clear();
            list.add(triangle);
        }
    }

    public List<IsoscelesTriangle> getList() {
        return list;
    }
}
