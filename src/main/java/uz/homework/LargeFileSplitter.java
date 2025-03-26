package uz.homework;

import java.io.*;
import java.nio.file.*;

// Katta hajmdagi faylni ma’lum hajmdagi kichik fayllarga bo‘lib chiqish.
public class LargeFileSplitter {
    public static void splitFile(String sourceFile, int partSize) throws IOException {
        Path sourcePath = Paths.get(sourceFile);
        byte[] buffer = new byte[partSize];
        int partNumber = 1;

        try (InputStream inputStream = Files.newInputStream(sourcePath)) {
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String partFileName = sourceFile + ".part" + partNumber++;
                try (OutputStream outputStream = Files.newOutputStream(Paths.get(partFileName))) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        }
        System.out.println("File splitting completed!");
    }

    public static void main(String[] args) throws IOException {
        splitFile("error.log", 1024); // 1MB parts
    }

    // 1 byte = 8 bit
    // 1 KB = 1024 byte
    // 1 MB = 1024 KB = 1024*1024 byte
    // 1 GB = 1024 MB = 1024*1024 KB = 1024*1024*1024 byte
}
