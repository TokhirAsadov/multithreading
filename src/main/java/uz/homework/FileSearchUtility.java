package uz.homework;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileSearchUtility {
    public static void searchInFile(String filePath, String keyword) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.filter(line -> line.contains(keyword))
                    .forEach(System.out::println);
        }
    }

    public static void main(String[] args) throws IOException {
        searchInFile("error.log", "Logger thread");
    }
}