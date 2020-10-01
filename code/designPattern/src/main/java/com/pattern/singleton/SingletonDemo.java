package com.pattern.singleton;

import java.util.Locale;

/**
 * @author tania.gupta
 * @date 01/06/20
 */
public class SingletonDemo {

    public static void main(String args[]) {

        Singleton s = Singleton.getInstance();

        Singleton s1 = Singleton.getInstance();

        if (s == s1)
            System.out.println(true);

    }
}
