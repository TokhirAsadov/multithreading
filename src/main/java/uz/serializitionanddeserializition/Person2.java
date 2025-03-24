package uz.serializitionanddeserializition;

import java.io.*;

public class Person2 implements Externalizable {
    private String name;
    private int age;
    private String password;

    public Person2() {
    }

    public Person2(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name.substring(0,3));
        out.writeInt(age*10);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }
}
