package uz.ioandnoi;

import java.io.*;

public class BufferWriterAndReaderExample {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("io/readme.txt"));){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void m1(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("io/readme.txt",true));){
//            bw.write("\nHello, World!");
            bw.newLine();
            bw.write("Hello, Java!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
