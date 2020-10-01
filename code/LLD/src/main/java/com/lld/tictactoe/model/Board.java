package com.lld.tictactoe.model;

import java.util.Arrays;

/**
 * @author tania.gupta
 * @date 24/06/20
 */
public class Board {

    Cell cell;

    private int[][] position;

    private final int rowSum[], colSum[];
    private int diagonalSum, reverseDiagonalSum;

    public Board(int n) {

        this.position = new int[n][n];
        for (int[] i : position) {
            Arrays.fill(i, -1);
        }

        cell = new Cell();

        rowSum = new int[n];
        colSum = new int[n];
        diagonalSum = 0;
        reverseDiagonalSum = 0;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int[][] getPosition() {
        return position;
    }

    public int[] getRowSum() {
        return rowSum;
    }

    public int[] getColSum() {
        return colSum;
    }

    public int getDiagonalSum() {
        return diagonalSum;
    }

    public int getReverseDiagonalSum() {
        return reverseDiagonalSum;
    }

    public void setPosition(Cell cell, int value) {
        this.position[cell.row][cell.column] = value;
    }

    public void setDiagonalSum(int diagonalSum) {
        this.diagonalSum = diagonalSum;
    }

    public void setReverseDiagonalSum(int reverseDiagonalSum) {
        this.reverseDiagonalSum = reverseDiagonalSum;
    }
}
