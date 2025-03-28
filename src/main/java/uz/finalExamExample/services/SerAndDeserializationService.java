package uz.finalExamExample.services;

import uz.finalExamExample.database.DB;
import uz.finalExamExample.entity.User;
import uz.serializitionanddeserializition.Person2;

import java.io.*;
import java.util.List;

import static uz.finalExamExample.database.DB.users;

public class SerAndDeserializationService {
    public static <T extends Serializable> void serialized(T t, File file){
        try(FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            ObjectOutputStream objectOutputStream = (file.exists() && file.length()>0)
                    ? new AppendableObjectOutputStream(fileOutputStream)
                    :new ObjectOutputStream(fileOutputStream))
        {
            objectOutputStream.writeObject(t);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static <T extends Serializable> void deserialized(File file, List<T> list){
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    T readObject =(T) ois.readObject();
                    list.add(readObject);
                } catch (EOFException e) {
                    break; // Fayl oxiriga yetganimizda chiqamiz
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void makingDatabase(){
        deserialized(new File("final/users.txt"), users);
//        deserialized(new File("final/cards.txt"), cards);
//        deserialized(new File("final/products.txt"), products);
//        deserialized(new File("final/order.txt"), orders);
//        deserialized(new File("final/histories.txt"), histories);
    }


}
