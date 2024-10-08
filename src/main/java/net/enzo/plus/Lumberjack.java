package net.enzo.plus;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lumberjack {
    public static final Logger logger = LogManager.getLogger("plus");

    public static void log(Level level, Throwable e, Object message) {
        log(level, message);
        e.printStackTrace();
    }

    public static void log(Level level, Object message) {
        logger.log(level, message);
    }

    public static void info(Object message) {
        log(Level.INFO, message);
    }
    public static void debug(Object message) {
        log(Level.INFO, "[Debug]: " + message);
    }
}
