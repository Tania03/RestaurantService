package com.lld.tictactoe.model;

/**
 * @author tania.gupta
 * @date 24/06/20
 */
public class Player {

    private String playerId;

    private int symbol;

    public Player(String playerId, int symbol) {
        this.playerId = playerId;
        this.symbol = symbol;
    }

    public int getSymbol() {
        return symbol;
    }
}
