package org.example.filehandling;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class FileHandlerDemo {
    public static void main(String[] args) {
        ReadFileOperation readFileOperation = new ScannerReaderDemo();
        readFileOperation.readFile();
    }

    public void createFile(){
        File file = new File("C:/Users/cogni/dj/filedemo.txt");
        try {
            file.createNewFile();
            System.out.println("file created successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
