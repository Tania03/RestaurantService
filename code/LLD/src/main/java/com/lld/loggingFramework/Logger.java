package com.lld.loggingFramework;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public abstract class Logger {

    int level;
    Logger nextHandler;

    public void setNextHandler(Logger nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void log(Level level, String message) {

        if (this.level <= level.getLevel())
            log(message);

        if (this.nextHandler != null)
            nextHandler.log(level, message);
    }

    protected abstract void log(String message);
}
