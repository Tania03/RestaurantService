package com.pattern.chainOfResponsibility;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class FileLogger extends Logger {

    public FileLogger(int level) {
        this.currentLogLevel = level;
    }


    @Override
    public void displayMessage(String msg) {
        System.out.println("File Handler : " + msg);
    }
}
