package com.lld.tictactoe.enums;

/**
 * @author tania.gupta
 * @date 24/06/20
 */
public enum Winner {

    PLAYER1("Player1"), PLAYER2("Player2"), DRAW("Draw"), UNDECIDED("Undecided");

    String status;

    Winner(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
