package ru.mishapan.isoscelestriangle.filereaderwriter;

import ru.mishapan.isoscelestriangle.IsoscelesTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Reads stings from file and saves objects of IsoscelesTriangle class with the largest area
 */
public class TriangleReader {

    private List<IsoscelesTriangle> list = new ArrayList<>();
    private Logger lg = new Logger();

    /**
     * Method reads strings from text file, splits up every and puts result to array of doubles
     * Creates new IsoscelesTriangle instance with array as param and transfers it to method saveIfTheLargest
     *
     * @param path path of the input file
     */
    public void readAndSave(String path) {

        try (BufferedReader bf = new BufferedReader(new java.io.FileReader(path))) {

            System.out.println(" > Reading file at " + LocalDateTime.now() + "...");

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

        System.out.println(" > File read at " + LocalDateTime.now());

    }


    /**
     * Method adds objects of IsoscelesTriangle class to list. If list is empty adds one object.
     * If list isn't empty and area of object is equal to area of first object in list, adds this object to list.
     * If list isn't empty and area of object bigger than area of first object in list, adds this object to cleaned
     * list.
     *
     * @param triangle object of IsoscelesTriangle class
     */
    private void saveIfTheLargest(IsoscelesTriangle triangle) {

        if (triangle == null) {
            return;
        }

        if (list.size() == 0) {
            list.add(triangle);
            return;
        }

        IsoscelesTriangle triangleFromList = list.get(0);

        if (triangle.getArea() == triangleFromList.getArea() &&
                triangle.getCoordinates() != triangleFromList.getCoordinates()) {
            list.add(triangle);
            return;
        }

        if (triangle.getArea() > triangleFromList.getArea()) {
            list.clear();
            list.add(triangle);
        }
    }

    public List<IsoscelesTriangle> getList() {
        return list;
    }
}
