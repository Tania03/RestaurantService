package com.lld.chess.model;

import com.lld.chess.enums.Color;

/**
 * @author tania.gupta
 * @date 16/08/20
 */
public class Pawn extends Piece{

    public Pawn(Color color) {
        this.color = color;
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
