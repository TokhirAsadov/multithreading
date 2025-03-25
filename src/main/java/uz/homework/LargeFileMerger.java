package uz.homework;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.*;

public class LargeFileMerger {
    private static final Object LOCK = new Object(); // Sinxronizatsiya uchun obyekt
    private static OutputStream outputStream;

    public static void mergeFiles(List<String> inputFiles, String outputFile) throws IOException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Global OutputStream ochamiz
        outputStream = Files.newOutputStream(Paths.get(outputFile), StandardOpenOption.CREATE);

        for (String file : inputFiles) {
            executor.submit(() -> {
                try (InputStream inputStream = Files.newInputStream(Paths.get(file))) {
                    byte[] buffer = new byte[1024*3];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        synchronized (LOCK) {  // Global LOCK ishlatamiz
                            outputStream.write(buffer, 0, bytesRead);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);

        // OutputStream'ni oxirida yopamiz
        synchronized (LOCK) {
            outputStream.close();
        }

        System.out.println("Merging completed!");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        mergeFiles(List.of("error.log", "error.log.part1", "error.log.part2"), "merged.log");
    }
}


