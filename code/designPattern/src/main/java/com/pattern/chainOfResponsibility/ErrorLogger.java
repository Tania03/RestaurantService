package com.pattern.chainOfResponsibility;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class ErrorLogger extends Logger {

    public ErrorLogger(int level) {
        this.currentLogLevel = level;
    }


    @Override
    public void displayMessage(String msg) {
        System.out.println("Error Handler : " + msg);
    }
}
