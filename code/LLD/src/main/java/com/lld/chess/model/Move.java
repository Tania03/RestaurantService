package com.lld.chess.model;

/**
 * @author tania.gupta
 * @date 16/08/20
 */
public class Move {

    private Player player;
    private Box startBox;
    private Box endBox;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private Boolean isCastlingMove;
}
