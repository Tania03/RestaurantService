package com.pattern.chainOfResponsibility;

import com.pattern.chainOfResponsibility.enums.Level;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class LoggerMain {

    private static Logger getChainOfLoggers() {

        ErrorLogger errorLogger = new ErrorLogger(Level.ERROR.getLevel());

        FileLogger fileLogger = new FileLogger(Level.INFO.getLevel());
        errorLogger.setNextLevelHandler(fileLogger);

        ConsoleLogger consoleLogger = new ConsoleLogger(Level.DEBUG.getLevel());
        fileLogger.setNextLevelHandler(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {

        Logger logger = LoggerMain.getChainOfLoggers();

        logger.logMessage(Level.DEBUG, "I am at debug level");
        System.out.println();
        logger.logMessage(Level.INFO, "I am at info level");
        System.out.println();
        logger.logMessage(Level.ERROR, "I am at error level");
    }
}
