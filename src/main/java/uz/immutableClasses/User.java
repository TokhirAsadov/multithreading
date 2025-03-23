package uz.immutableClasses;



///user{
//    fullName
//    emails[] -> List
//    HashMap<Integer, Course> coursesMap
//}
//

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class User {
    private final String fullName;
    private final List<String> emails;
    private final HashMap<Integer, Course> courses;

    public User(String fullName, List<String> emails, HashMap<Integer, Course> courses) {
        this.fullName = fullName;
        this.emails = List.of(emails.toString());
        this.courses = courses;
    }

    public String getFullName() {
        return fullName;
    }

    public List<String> getEmails() {
        return emails;
    }

    public HashMap<Integer, Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", emails=" + emails +
                ", courses=" + courses +
                '}';
    }
}
