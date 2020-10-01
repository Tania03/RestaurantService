package com.lld.loggingFramework;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public enum Level {

    TRACE(0), DEBUG(1), INFO(2), ERROR(3), SEVERE(4);

    int level;

    Level(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
