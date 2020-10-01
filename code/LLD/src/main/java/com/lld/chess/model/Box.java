package com.lld.chess.model;

/**
 * @author tania.gupta
 * @date 16/08/20
 */
public class Box {

    int x;
    int y;
    Piece piece;

    public Box() {
    }

    public Box(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
}
