package com.pattern.chainOfResponsibility;

import com.pattern.chainOfResponsibility.enums.Level;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class ConsoleLogger extends Logger {

    public ConsoleLogger(int level) {
        this.currentLogLevel = level;
    }


    @Override
    public void displayMessage(String msg) {
        System.out.println("Console Handler : " + msg);
    }
}
