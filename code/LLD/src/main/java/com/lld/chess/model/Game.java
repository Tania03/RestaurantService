package com.lld.chess.model;

import com.lld.chess.enums.GameStatus;

import java.util.List;

/**
 * @author tania.gupta
 * @date 16/08/20
 */
public class Game {

    Board board;
    Player[] player;
    List<Move> moveList;
    Player currentTurn;
    GameStatus gamestatus;

}
