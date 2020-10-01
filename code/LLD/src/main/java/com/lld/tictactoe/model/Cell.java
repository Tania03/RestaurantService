package com.lld.tictactoe.model;

/**
 * @author tania.gupta
 * @date 25/06/20
 */
public class Cell {

    int row;
    int column;

    public Cell() {
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
