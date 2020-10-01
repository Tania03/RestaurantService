package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;

/**
 * @author tania.gupta
 * @date 19/07/20
 */
public class Constructor {

    public static void main(String... arrrrgs) {

        String[] cities = {"Bangalore", "Pune", "San Francisco", "New York City"};
        MySort ms = new MySort();
        Arrays.sort(cities, ms);
        System.out.println(Arrays.binarySearch(cities, "New York City"));

        Integer i = 120;
        Integer j = 120;
        System.out.println(i == j);
        System.out.println(",");
        i = 300;
        j = 300;
        System.out.println(i == j);

        try {
            throw new Exc1();
        } catch (Exc0 e0) {
            System.out.println("Ex0 caught");
        } catch (Exception e) {
            System.out.println("exception caught");
        }

        try {
            Float f1 = new Float("3.0");
            int x = f1.intValue();
            byte b = f1.byteValue();
            double d = f1.doubleValue();
            System.out.println(x + b + d);
        } catch (NumberFormatException e) {
            System.out.println("bn");
        }

        Properties p = System.getProperties();
        p.setProperty("pirate", "scurvy");
        String s = p.getProperty("argProp") + " ";
        s += p.getProperty("pirate");
        System.out.println(s);

        try {
            badMethod();
            System.out.println("A");
        } catch (Exception ex) {
            System.out.println("B");
        } finally {
            System.out.println("C");
        }
        System.out.println("D");


        System.out.println(getInt());
    }

    private static int getInt() {
        try {
            System.out.println("In try Block");
            return 1;
        } catch (Exception e) {
            System.out.println("In catch");
            return 2;
        } finally {
            System.out.println("In finally");
            return 3;
        }

    }

    public static void badMethod() {
        throw new RuntimeException();
    }

    static class MySort implements Comparator<String> {

        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }
}

class Exc0 extends Exception {
}

class Exc1 extends Exc0 {
}

