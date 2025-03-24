package uz.ioandnoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        try ( FileOutputStream fos = new FileOutputStream("io/readme.txt", true);) {
            fos.write("\nAlijon".getBytes());
            fos.write(45);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
