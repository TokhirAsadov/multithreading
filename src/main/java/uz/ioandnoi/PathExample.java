package uz.ioandnoi;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {

        Path path = Path.of("io/readme.txt");
        System.out.println(path.getFileName());
//        Path path = Paths.get("io");
//        System.out.println(path);
//        path = path.resolve("readme.txt");
//        System.out.println(path);
//        File file = new File("io/readme.txt");
//        Path path = Paths.get(file.getAbsolutePath());
//        System.out.println(path.getFileName());
//        System.out.println(path.getParent());
//        System.out.println(path.getRoot());

    }
}
