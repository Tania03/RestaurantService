package com.swiggy.battleship.board;

import com.swiggy.battleship.models.Constants;

public class Position {
    private char row;
    private int col;

    public Position(char row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRowIndex() {
        return row - Constants.ROW_START_CHAR;
    }

    public int getColIndex() {
        return col - 1;
    }

    @Override
    public String toString() {
        return "Position: [row=" + row + ", col=" + col + "]";
    }
}