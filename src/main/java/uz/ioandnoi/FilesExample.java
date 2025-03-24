package uz.ioandnoi;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class FilesExample {
    public static void main(String[] args) {
        try {
//            Path path = Files.createFile(Path.of("nio/readme.txt"));
//            System.out.println(path.getFileName());
//            Path path = Files.createDirectory(Path.of("nio/child5/child6"));
//            Path path = Files.createDirectories(Path.of("nio/follow"));

//            Path path = Files.write(Path.of("nio/readme.txt"), "Hello, G52!".getBytes());
//            Path path = Files.writeString(Path.of("nio/readme.txt"), "Hello, mutithreading!");

//            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("nio/readme.txt"));){
//                bufferedWriter.newLine();
//                bufferedWriter.write("Hello, G52! ==========");
//            }

//            Files.copy(Path.of("nio/readme.txt"), Path.of("nio/readme2.txt"), StandardCopyOption.REPLACE_EXISTING);
//            Files.write(Path.of("nio/readme.txt"), "\nHello, 444!".getBytes(), StandardOpenOption.APPEND);
//            Files.readAllLines(Path.of("nio/readme.txt")).forEach(System.out::println);
//            Files.readAllLines(Path.of("D:\\pdp\\G52\\road map.txt")).forEach(System.out::println);
            Stream<Path> walk = Files.walk(Path.of("D:\\pdp\\G52"));
            walk.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
