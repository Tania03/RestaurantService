package com.swiggy.battleship.board;

import com.swiggy.battleship.game.AttackResult;
import com.swiggy.battleship.ship.Ship;

import java.util.ArrayList;
import java.util.List;

public class Board {

    int numberRows;
    int numberCols;
    BoardTypeTarget[][] targetBoard;
    BoardTypeOcean[][] oceanBoard;
    List<Ship> ships;

    void initDefaults() {
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberCols; j++) {
                targetBoard[i][j] = BoardTypeTarget.Unknown;
                oceanBoard[i][j] = BoardTypeOcean.Nil;
            }
        }
    }

    public Board(int numberRows, int numberCols) {
        this.numberCols = numberCols;
        this.numberRows = numberRows;
        targetBoard = new BoardTypeTarget[numberRows][numberCols];
        oceanBoard = new BoardTypeOcean[numberRows][numberCols];
        ships = new ArrayList<Ship>();
        initDefaults();
    }

    public boolean isPlaceShipValid(Ship ship) {
        return placeShip(ship, false);
    }

    public void placeShip(Ship ship) {
        placeShip(ship, true);
        ships.add(ship);
    }


    /**
     * @param ship
     * @param toUpdateBoard
     * @return
     */
    private boolean placeShip(Ship ship, boolean toUpdateBoard) {

        int rowPos = ship.getPosition().getRowIndex();
        int colPos = ship.getPosition().getColIndex();

        for (int s = 0; s < ship.getLength(); s++) {

            int row = rowPos;
            int col = colPos;

            switch (ship.getOrientation()) {
                case Vertical:
                    row = rowPos + s;
                    break;
                case Horizontal:
                    col = colPos + s;
                    break;
            }

            if (isValid(row, col) && oceanBoard[row][col] == BoardTypeOcean.Nil) {
                if (toUpdateBoard) {
                    oceanBoard[row][col] = BoardTypeOcean.Ship;
                }
            } else {
                if (isValid(row, col)) {
                    System.out.println("A ship already exists in same position, row - " + row + ", col - " + col + " val = " + oceanBoard[row][col]);
                } else {
                    System.out.println("Cannot place ship in invalid position, row - " + row + ", col - " + col);
                }
                return false;
            }
        }
        return true;
    }


    /**
     * @param rowPos
     * @param colPos
     * @return
     */
    private boolean isValid(int rowPos, int colPos) {
        if (rowPos >= 0 && rowPos < numberRows && colPos >= 0 && colPos < numberCols)
            return true;
        return false;
    }

    /**
     * @param attackPos
     * @return
     */
    public AttackResult attack(Position attackPos) {

        int r = attackPos.getRowIndex();
        int c = attackPos.getColIndex();

        if (!isValid(r, c) || oceanBoard[r][c] == BoardTypeOcean.ShipHit) {
            System.out.println("Invalid position when attacking opponent player!");
            return AttackResult.Invalid;
        }

        if (oceanBoard[r][c] == BoardTypeOcean.Ship) {
            oceanBoard[r][c] = BoardTypeOcean.ShipHit;
            return AttackResult.Hit;
        }

        return AttackResult.Miss;
    }

    /**
     * @param attackPos
     * @param result
     */
    public void updateTargetBoard(Position attackPos, AttackResult result) {

        int r = attackPos.getRowIndex();
        int c = attackPos.getColIndex();

        if (!isValid(r, c)) {
            System.out.print(" Invalid position when updating attack result in player's board! ");
            return;
        }

        if (result.equals(AttackResult.Hit)) {
            targetBoard[r][c] = BoardTypeTarget.Hit;
        } else {
            targetBoard[r][c] = BoardTypeTarget.Miss;
        }

    }

    public boolean checkIfAllShipsSunk() {

        //find any one cell which has ship and is not hit
        for (int r = 0; r < numberRows; r++)
            for (int c = 0; c < numberCols; c++) {
                if (oceanBoard[r][c] == BoardTypeOcean.Ship)
                    return false;
            }

        return true;
    }


    /**
     *
     */
    public void print() {
        printPretty(true);
        printPretty(false);
        System.out.println();
        System.out.println();
    }

    void printPretty(boolean isOceanBoard) {
        System.out.println("---------------Printing Ocean board-------------------");
        System.out.print("  ");
        for (int c = 1; c <= numberCols; c++) {
            System.out.print(c + " | ");
        }
        System.out.println();

        Character ch = 'A';
        for (int r = 0; r < numberRows; r++) {
            System.out.print(ch.toString() + " ");
            ch++;
            for (int c = 0; c < numberCols; c++) {
                if (isOceanBoard) System.out.print(oceanBoard[r][c] + " | ");
                else System.out.print(targetBoard[r][c] + " | ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
