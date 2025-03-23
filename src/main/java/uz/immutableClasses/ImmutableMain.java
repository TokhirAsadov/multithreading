package uz.immutableClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ImmutableMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        HashSet<String> modules = new HashSet<>();
        modules.add("Module 1");
        Course course = new Course("matematika", modules);
        modules.add("Module 2");

        List<String> emails = new ArrayList<>();
        emails.add("123@gmail.com");
        emails.add("456@gmail.com");

        HashMap<Integer,Course> courseHashMap = new HashMap<>();
        courseHashMap.put(1,course);
        User user = new User("Azizbek", emails, courseHashMap);

        emails.add("0000@gmail.com");

        HashSet<String> modules2 = new HashSet<>();
        modules.add("Module 8");
        Course course1 = new Course("fizika", modules);
        courseHashMap.put(2,course1);

        System.out.println(user);


        System.out.println(course.toString());

    }
}
