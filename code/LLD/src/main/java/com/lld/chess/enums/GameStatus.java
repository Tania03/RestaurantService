package com.lld.chess.enums;

/**
 * @author tania.gupta
 * @date 16/08/20
 */
public enum GameStatus {

    WINNER_PLAYER_1("Player 1 Winner"), WINNER_PLAYER_2("Player 1 Winner"), DRAW("DRAW");

    String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
