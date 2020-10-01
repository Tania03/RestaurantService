package com.lld.loggingFramework;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class WebsiteLogger extends Logger {

    public WebsiteLogger(int level) {
        this.level = level;
    }

    public void log(String message) {
        System.out.println("Website Logger : " + message);
    }

}
