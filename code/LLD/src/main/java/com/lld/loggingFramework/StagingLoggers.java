package com.lld.loggingFramework;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class StagingLoggers implements LoggerType {

    public Logger createLogger() {

        ConsoleLogger consoleLogger = new ConsoleLogger(Level.DEBUG.getLevel());
        return consoleLogger;
    }
}
