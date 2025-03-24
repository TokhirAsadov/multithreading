package uz.ioandnoi;

import java.io.*;

public class DataOutputAndInputStreamExample {
    public static void main(String[] args) {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("io/readme.txt",true));) {

//            dos.write("\n".getBytes());

            float f = 12.5f;
            long l = 5L;
            double d = 2.5;

            dos.writeLong(l);
            dos.writeFloat(f);
            dos.writeDouble(d);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream("io/readme.txt"));){
            System.out.println(dis.readLong());
            System.out.println(dis.readFloat());
            System.out.println(dis.readDouble());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
