package ru.mishapan.IsoscelesTriangle.FileReaderWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {

    Logger() {

        try (BufferedWriter bf = new BufferedWriter(new FileWriter("logs.txt"))) {
            bf.write("Line    Exception   |   Date : " + new Date());
            bf.write("\n---------------------------------\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void write(String massage) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("logs.txt", true))) {
            bf.write(massage);
            bf.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
