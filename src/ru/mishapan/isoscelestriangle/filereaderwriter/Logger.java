package ru.mishapan.isoscelestriangle.filereaderwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Write logs
 */
public class Logger {

    /**
     * Creates text file
     */
    Logger() {

        try (BufferedWriter bf = new BufferedWriter(new FileWriter("logs.txt"))) {
            bf.write("Line    Exception   |   Date : " + LocalDateTime.now());
            bf.newLine();
            bf.write("---------------------------------");
            bf.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Writes message to file
     *
     * @param message string contains number of file's string and Exception message
     */
    public void write(String message) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("logs.txt", true))) {
            bf.write(message);
            bf.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
