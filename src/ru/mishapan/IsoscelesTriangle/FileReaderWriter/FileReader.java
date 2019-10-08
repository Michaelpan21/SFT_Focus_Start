package ru.mishapan.IsoscelesTriangle.FileReaderWriter;

import ru.mishapan.IsoscelesTriangle.IsoscelesTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileReader {

    private List<IsoscelesTriangle> list = new LinkedList<>();

    public void readAndSave(String path) {

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
                    IsoscelesTriangle triangle = new IsoscelesTriangle(coordinates);
                    saveIfTheLargest(triangle);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void saveIfTheLargest(IsoscelesTriangle triangle) {

        if (list.size() == 0) {
            list.add(triangle);
            return;
        }

        if (triangle.getSquare() > list.get(0).getSquare()) {
            list.clear();
            list.add(triangle);
        }
        if (triangle.getSquare() == list.get(0).getSquare()) {
            list.add(triangle);
        }
    }

    public List<IsoscelesTriangle> getList() {
        return list;
    }
}
