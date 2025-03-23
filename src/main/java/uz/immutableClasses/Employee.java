package uz.immutableClasses;

import java.util.Arrays;

// 1 qoida final class bo`lishi kk - extends ni cheklash
public final class Employee {
    //2.1 final va 2.2 private
    private final String fullName;
    private final int age;
    private final int[] keys;
    private final Address address;

    // 3. faqat construktor yordamida qiymat beriladi
    public Employee(String fullName, int age, int[] keys, Address address) throws CloneNotSupportedException {
        this.fullName=fullName;
        this.age=age;
        this.keys = keys.clone();
        this.address = (Address) address.clone();
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public int[] getKeys() {
        return keys.clone(); // deep cope
    }

    // 4. setter lar bo`lmaydi


    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", keys=" + Arrays.toString(keys) +
                ", address=" + address +
                '}';
    }
}
