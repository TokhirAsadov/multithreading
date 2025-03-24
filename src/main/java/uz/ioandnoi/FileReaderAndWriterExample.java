package uz.ioandnoi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWriterExample {
    public static void main(String[] args) {
        try(FileWriter fileWriter = new FileWriter("io/readme.txt", true);){
            fileWriter.write("\nAlijon");
            fileWriter.append("\nValijon");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void m1(){
        try(FileReader fileReader = new FileReader("io/readme.txt");) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
