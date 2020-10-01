package com.pattern.decorator;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class SimpleSandwich implements Sandwich {

    @Override
    public String make() {
        return "bread";
    }
}
