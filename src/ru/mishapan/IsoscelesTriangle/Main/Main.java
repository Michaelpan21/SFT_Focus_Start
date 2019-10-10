package ru.mishapan.IsoscelesTriangle.Main;

import ru.mishapan.IsoscelesTriangle.FileReaderWriter.FileReader;
import ru.mishapan.IsoscelesTriangle.FileReaderWriter.FileWriter;

import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {

        if (args.length < 2){
            throw new ArrayIndexOutOfBoundsException("Type two files");
        }

        Path filePathIn = Paths.get(args[0]).toAbsolutePath().normalize();
        Path filePathOut = Paths.get(args[1]).toAbsolutePath().normalize();

        FileReader fileIn = new FileReader();
        fileIn.readAndSave(filePathIn.toString());

        FileWriter fileOut = new FileWriter();
        fileOut.write(filePathOut.toString(), fileIn.getList());
    }
}
