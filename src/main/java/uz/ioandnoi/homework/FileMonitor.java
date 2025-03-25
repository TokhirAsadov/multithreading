package uz.ioandnoi.homework;

import java.io.IOException;
import java.nio.file.*;

public class FileMonitor {
    public static void watchDirectory(String directoryPath) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(directoryPath);
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        System.out.println("Watching directory: " + directoryPath);
        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("Change detected: " + event.kind() + " -> " + event.context());
            }
            key.reset();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        watchDirectory("D:/");
    }
}
