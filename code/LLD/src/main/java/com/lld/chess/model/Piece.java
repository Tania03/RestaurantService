package com.lld.chess.model;

import com.lld.chess.enums.Color;

/**
 * @author tania.gupta
 * @date 16/08/20
 */
public abstract class Piece {

    Color color;
    boolean isKilled;

    public abstract boolean canMove();
}
