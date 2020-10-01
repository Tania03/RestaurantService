package com.lld.chess.model;

import com.lld.chess.enums.Color;

/**
 * @author tania.gupta
 * @date 16/08/20
 */
public class Board {

    Box[][] box;
    private final int BOARD_SIZE = 8;

    public Board() {
        initializeBoard();
    }

    public void initializeBoard(){
        this.box = new Box[BOARD_SIZE][BOARD_SIZE];

        initializePawn();
        initializeRestPiece(0,Color.WHITE);
        initializeRestPiece(BOARD_SIZE - 1,Color.BLACK);
        initializeEmptyBoxes();

    }


    private void initializePawn() {

        for(int j = 0; j < BOARD_SIZE; j++) {
            box[1][j] = new Box(1, j, new Pawn(Color.WHITE));
            box[BOARD_SIZE - 2][j] = new Box(BOARD_SIZE - 2, j, new Pawn(Color.BLACK));
        }
    }

    private void initializeRestPiece(int x, Color color) {

        box[x][0] = new Box(x,0,new Bishop(color));
        box[x][1] = new Box(x,1,new Rook(color));
        box[x][2] = new Box(x,2,new Knight(color));

        if(color.equals(Color.BLACK)) {
            box[x][3] = new Box(x, 3, new Queen(color));
            box[x][4] = new Box(x, 4, new King(color));
        }
        else {
            box[x][3] = new Box(x, 3, new King(color));
            box[x][4] = new Box(x, 4, new Queen(color));
        }
        box[x][5] = new Box(x,5,new Knight(color));
        box[x][6] = new Box(x,6,new Rook(color));
        box[x][7] = new Box(x,7,new Bishop(color));

    }

    private void initializeEmptyBoxes() {

        for(int i = 2; i < BOARD_SIZE - 2; i++){
            for(int j = 0; j < BOARD_SIZE; j++)
                box[i][j] = new Box(i, j,null);
        }
    }

}
