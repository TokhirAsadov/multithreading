package uz.ioandnoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream(new File("io/readme.txt"));) {
            byte[] bytes = fis.readAllBytes();
            String data = new String(bytes);
            System.out.println("data = "+data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void m1(){
        // try-with-resources
        try(FileInputStream fis = new FileInputStream(new File("io/readme.txt"));) {
//            FileInputStream fis = new FileInputStream("io/readme.txt");
            StringBuilder s = new StringBuilder();
            while (fis.available() > 0) {
                s.append((char) fis.read());
            }
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
