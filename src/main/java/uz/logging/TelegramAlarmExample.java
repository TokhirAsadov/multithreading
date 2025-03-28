package uz.logging;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelegramAlarmExample {

    static {
        String file = TelegramAlarmExample.class.getClassLoader().getResource("logger.properties").getFile();
        System.setProperty("java.util.logging.config.file",file);
    }

    private static final Logger logger = Logger.getLogger(TelegramAlarmExample.class.getSimpleName());

    public static void main(String[] args) throws FileNotFoundException {
        try {
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Runtime Exception for alarm testing");
            } else {
                int coreCount = 12 / 0;
            }
        } catch (RuntimeException e){
            e.printStackTrace();
            // bu yerda exception loggerga berib yuborilyapdi; va bu exception LogRecord da thrown metodi orqali get qilinadi
            logger.log(Level.SEVERE,"Error Message For Telegram",e);
        }
    }
}
