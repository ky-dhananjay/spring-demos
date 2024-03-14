package org.example.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReaderDemo implements ReadFileOperation{
    @Override
    public void readFile() {
        try {
            // Create f1 object of the file to read data
            File f1 = new File("C:/Users/cogni/dj/fileWriterDemo.txt");
            Scanner dataReader = new Scanner(f1);
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }
            dataReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Unexcpected error occurred!");
            exception.printStackTrace();
        }
    }
}
