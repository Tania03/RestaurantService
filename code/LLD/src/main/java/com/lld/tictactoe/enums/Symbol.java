package com.lld.tictactoe.enums;

/**
 * @author tania.gupta
 * @date 24/06/20
 */
public enum Symbol {

    CROSS("1"), ZERO("0");

    String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
