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
        TelegramAlarmHandler handler = new TelegramAlarmHandler();
        logger.addHandler(handler);

        if (new Random().nextBoolean()){
            logger.log(Level.SEVERE,"Dasturda xatolik bor!");
            try {
                int coreCount = 12 / 0;
            }catch (Exception e){
                String s = "\n";
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);

                s=s+stringWriter.getBuffer();

                logger.log(Level.SEVERE,s);
                printWriter.close();
                throw new RuntimeException(e);
            }

        }else {
            logger.log(Level.INFO,"Hammasi joyida");
        }
    }
}
