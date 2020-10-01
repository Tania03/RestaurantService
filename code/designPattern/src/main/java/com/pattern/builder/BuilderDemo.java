package com.pattern.builder;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class BuilderDemo {

    public static void main(String[] args) {

        LunchOrder lunchOrder = new LunchOrder.Builder("Bread")
                .both("condiments", "dressing").build();

        System.out.println(lunchOrder.toString());
    }
}
