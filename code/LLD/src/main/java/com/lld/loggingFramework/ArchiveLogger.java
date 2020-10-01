package com.lld.loggingFramework;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class ArchiveLogger extends Logger {

    public ArchiveLogger(int level) {
        this.level = level;
    }

    public void log(String message) {
        System.out.println("Archive Logger : " + message);
    }
}
