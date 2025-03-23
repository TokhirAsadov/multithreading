package uz.handsOnMiniProject.service;

import uz.handsOnMiniProject.threads.LoggerThread;

public class ThreadService {
    public void creatingNewThread() {
        Thread thread = new Thread(new LoggerThread());
        thread.start();
    }
}
