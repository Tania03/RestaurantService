package com.pattern.singleton;

/**
 * @author tania.gupta
 * @date 01/06/20
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    ;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }


}
