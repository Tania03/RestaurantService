package com.pattern.decorator;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class SandwichDecoratorDemo {

    public static void main(String[] args) {

        Sandwich sandwich = new CheeseSandwichDecorator(new LettuceSandwichDecorator(new SimpleSandwich()));

        System.out.println(sandwich.make());

    }
}
