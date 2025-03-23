package uz.immutableClasses;

//course{
//    name;
//    set<string> modules;
//}

import java.util.Collections;
import java.util.Set;

public final class Course {
    private final String name;
    private final Set<String> modules;

    public Course(String name, Set<String> modules) {
        this.name = name;
        this.modules = Set.of(modules.toString());
    }

    public String getName() {
        return name;
    }

    public Set<String> getModules() {
        return modules;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", modules=" + modules +
                '}';
    }
}
