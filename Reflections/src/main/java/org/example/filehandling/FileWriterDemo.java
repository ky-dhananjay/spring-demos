package org.example.filehandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo implements WriteFileOperation {
    @Override
    public void writeOperation() {
        try {
            FileWriter fwrite = new FileWriter("C:/Users/cogni/dj/fileWriterDemo.txt");
            // writing the content into the FileOperationExample.txt file
            fwrite.write("A named location used to store related information is referred to as a File.");

            // Closing the stream
            fwrite.close();
            System.out.println("Content is successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }
}
