package com.pattern.chainOfResponsibility.enums;

/**
 * @author tania.gupta
 * @date 11/07/20
 */
public enum Level {

    DEBUG(1), INFO(2), WARN(3), ERROR(4);

    int level;

    Level(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
