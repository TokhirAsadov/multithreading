package uz.serializitionanddeserializition;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerAndDeserExample {
    public static void main(String[] args) {
//         serialized();
         deserialized();
    }

    public static void deserialized(){
        try{
            FileInputStream fis = new FileInputStream("io/person.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person2 person =(Person2) ois.readObject();
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void serialized(){
        try{
            Person2 person = new Person2("John", 30,"parol123");
            FileOutputStream fileOutputStream = new FileOutputStream("io/person.txt", true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
