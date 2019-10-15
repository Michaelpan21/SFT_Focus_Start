package ru.mishapan.isoscelestriangle.main;

import ru.mishapan.isoscelestriangle.filereaderwriter.TriangleReader;
import ru.mishapan.isoscelestriangle.filereaderwriter.FileWriter;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {


    /**
     * Reads coordinates from file and save the largest
     * Writes coordinates to file
     *
     * @param args contains name of input file and name of output file
     */
    public static void main(String[] args) {

        if (args.length != 2) {
            throw new IllegalArgumentException("Type two files");
        }

        Path filePathIn = Paths.get(args[0]).toAbsolutePath().normalize();
        Path filePathOut = Paths.get(args[1]).toAbsolutePath().normalize();

        TriangleReader fileIn = new TriangleReader();
        fileIn.readAndSave(filePathIn.toString());

        FileWriter fileOut = new FileWriter();
        fileOut.write(filePathOut.toString(), fileIn.getList());
    }
}
