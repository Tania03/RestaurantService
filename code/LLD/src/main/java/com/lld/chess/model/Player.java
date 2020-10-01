package com.lld.chess.model;

import com.lld.chess.enums.Color;

/**
 * @author tania.gupta
 * @date 16/08/20
 */
public class Player {

    String playerId;
    String name;
    Color color;

    public Player(Color color) {
        this.color = color;
    }
}
