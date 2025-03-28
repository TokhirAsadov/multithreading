package uz.serializitionanddeserializition;

import java.io.*;

public class SerAndDeserExample {
    public static void main(String[] args) {
//        serialized();
         deserialized();
//         serialized(true);
//        deserializedMulti();
    }

    public static void deserialized(){
        try{
            FileInputStream fis = new FileInputStream("io/person.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person2 person =(Person2) ois.readObject();
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getPassword());
            Person2 person2 =(Person2) ois.readObject();
            System.out.println(person2.getName());
            System.out.println(person2.getAge());
            System.out.println(person2.getPassword());
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

    public static void serialized(boolean append) {
        File file = new File("io/person.txt");

        try (FileOutputStream fos = new FileOutputStream(file, append);
             ObjectOutputStream oos = (file.exists() && file.length() > 0 && append)
                     ? new AppendableObjectOutputStream(fos)
                     : new ObjectOutputStream(fos)) {

            oos.writeObject(new Person2("John", 30, "parol123"));
            oos.writeObject(new Person2("Jane", 25, "secret321"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void deserializedMulti() {
        try (FileInputStream fis = new FileInputStream("io/person.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    Person2 person = (Person2) ois.readObject();
                    System.out.println("Name: " + person.getName());
                    System.out.println("Age: " + person.getAge());
                    System.out.println("Password: " + person.getPassword());
                } catch (EOFException e) {
                    break; // Fayl oxiriga yetganimizda chiqamiz
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


// Append rejimi uchun ObjectOutputStream klassini o‘zgartiramiz
class AppendableObjectOutputStream extends ObjectOutputStream {

    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}