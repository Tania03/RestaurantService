package com.pattern.chainOfResponsibility;

import com.pattern.chainOfResponsibility.enums.Level;

/**
 * @author tania.gupta
 * @date 11/07/20
 */
public abstract class Logger {

    protected int currentLogLevel;
    protected Logger nextLevelHandler;

    public void setCurrentLogLevel(Level logLevel) {
        this.currentLogLevel = logLevel.getLevel();
    }

    public void setNextLevelHandler(Logger logger) {
        this.nextLevelHandler = logger;
    }

    public void logMessage(Level level, String message) {

        if (this.currentLogLevel <= level.getLevel()) {
            displayMessage(message);
        }

        if (this.nextLevelHandler != null)
            nextLevelHandler.logMessage(level, message);

    }

    public abstract void displayMessage(String msg);

}
