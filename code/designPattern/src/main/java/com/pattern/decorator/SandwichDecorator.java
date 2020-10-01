package com.pattern.decorator;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public abstract class SandwichDecorator implements Sandwich {

    protected Sandwich customSandwich;

    public SandwichDecorator(Sandwich sandwich) {
        this.customSandwich = sandwich;
    }

    @Override
    public String make() {
        return customSandwich.toString();
    }
}
