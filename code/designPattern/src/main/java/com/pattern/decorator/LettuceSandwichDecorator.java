package com.pattern.decorator;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class LettuceSandwichDecorator extends SandwichDecorator implements Sandwich {


    public LettuceSandwichDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    @Override
    public String make() {
        return customSandwich.make() + " " + add();
    }

    private String add() {
        return "lettuce";
    }

}
