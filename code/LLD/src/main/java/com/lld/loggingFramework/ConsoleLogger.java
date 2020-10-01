package com.lld.loggingFramework;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class ConsoleLogger extends Logger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    public void log(String message) {
        System.out.println("Console Logger : " + message);
    }
}
