package uz.logging;

import java.io.IOException;
import java.util.logging.*;

public class LoggingExample {
    static {
        String file = LoggingExample.class.getClassLoader().getResource("logger.properties").getFile();
        System.setProperty("java.util.logging.config.file",file);
    }
    private static final Logger logger = Logger.getLogger("MyLogger");

    public static void main(String[] args) throws IOException {
//        logger.setUseParentHandlers(false);


//        ConsoleHandler consoleHandler = new ConsoleHandler();
//        consoleHandler.setLevel(Level.WARNING);
//        logger.addHandler(consoleHandler);

//        FileHandler fileHandler = new FileHandler("my-logger.log",true);
//        fileHandler.setFormatter(new SimpleFormatter());
//        fileHandler.setFilter(new Filter() {
//            @Override
//            public boolean isLoggable(LogRecord record) {
//                return record.getLevel().intValue()>=Level.WARNING.intValue();
//            }
//        });
//        fileHandler.setFilter(record -> record.getLevel().intValue()>=Level.WARNING.intValue());
//        logger.addHandler(fileHandler);


        logger.info("Hello from info");
        logger.warning("Hello from warning");
        logger.severe("severe");
        logger.fine("fine 11");
        logger.log(Level.FINE,"FINE dan log kelayapdi");
    }
}
