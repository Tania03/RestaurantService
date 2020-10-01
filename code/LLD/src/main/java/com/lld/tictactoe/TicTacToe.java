package com.lld.tictactoe;

import com.lld.tictactoe.enums.Symbol;
import com.lld.tictactoe.enums.Winner;
import com.lld.tictactoe.model.Board;
import com.lld.tictactoe.model.Cell;
import com.lld.tictactoe.model.Player;

import java.util.Random;


/**
 * @author tania.gupta
 * @date 24/06/20
 */
public class TicTacToe {

    private static final int BOARD_SIZE = 3;
    boolean currentPlayerP1;
    Player p1;
    Player p2;
    Board board;
    int moveCount = 0;
    Random random;

    public TicTacToe() {
        p1 = new Player("1", Integer.parseInt(Symbol.CROSS.getSymbol()));
        p2 = new Player("2", Integer.parseInt(Symbol.ZERO.getSymbol()));
        board = new Board(BOARD_SIZE);
        currentPlayerP1 = true;
        random = new Random();

    }

    public static void main(String args[]) {

        TicTacToe game = new TicTacToe();

        System.out.println("Game Begins !!");

        while (game.moveCount < BOARD_SIZE * BOARD_SIZE) {

            game.findEmptyPosition(game);

            int moveSymbol;
            int currentPlayerSymbol;

            Cell cell = game.board.getCell();

            if (game.currentPlayerP1) {
                System.out.println("Current player is : PLAYER_1");
                currentPlayerSymbol = game.p1.getSymbol();
                moveSymbol = game.play(currentPlayerSymbol, cell);
            } else {
                System.out.println("Current player is : PLAYER_2");
                currentPlayerSymbol = game.p2.getSymbol();
                moveSymbol = game.play(currentPlayerSymbol, cell);
            }

            System.out.println("Current position is : " + cell.getRow() + " : " + cell.getColumn());

            Winner winnerstatus = game.checkIfWinner(moveSymbol, currentPlayerSymbol, game);

            if (!winnerstatus.equals(Winner.UNDECIDED)) {
                System.out.println();
                System.out.println("WINNER is : " + winnerstatus.getStatus());
                return;
            } else {
                System.out.println("Current status is : " + winnerstatus.getStatus());
            }

            game.moveCount++;
            System.out.println("Total moves played : " + game.moveCount);

            game.currentPlayerP1 = !game.currentPlayerP1;

            System.out.println();
        }

        System.out.println("Match is : " + Winner.DRAW.getStatus());

    }

    /**
     * @param game the current game instance
     */
    private void findEmptyPosition(TicTacToe game) {

        int row;
        int column;

        while (true) {
            row = random.nextInt(BOARD_SIZE);
            column = random.nextInt(BOARD_SIZE);

            String currentValue = String.valueOf(game.board.getPosition()[row][column]);

            if (!currentValue.equals(Symbol.CROSS.getSymbol()) && !currentValue.equals(Symbol.ZERO.getSymbol()))
                break;
        }

        game.board.setCell(new Cell(row, column));

    }


    /**
     * Makes a move on the board and returns the symbol of the winner if
     * current move is a winning move.
     *
     * @param symbol is either 1 for player1 and -1 for player2
     * @param cell   position at which player1 plays
     * @return symbol of winner, 1 if player1 is winner, 0 if player2 is winner and - 1 otherwise
     */
    private int play(int symbol, Cell cell) {
        int result = -1;


        int add = symbol == 1 ? 1 : -1;
        board.setPosition(cell, symbol);

        int row = cell.getRow();
        int column = cell.getColumn();

        board.getRowSum()[row] += add;
        board.getColSum()[column] += add;

        if (row == column)
            board.setDiagonalSum(board.getDiagonalSum() + add);

        if (row == BOARD_SIZE - 1 - column)
            board.setReverseDiagonalSum(board.getReverseDiagonalSum() + add);

        if (Math.abs(board.getRowSum()[row]) == BOARD_SIZE
                || Math.abs(board.getColSum()[column]) == BOARD_SIZE
                || Math.abs(board.getDiagonalSum()) == BOARD_SIZE
                || Math.abs(board.getReverseDiagonalSum()) == BOARD_SIZE) {
            result = symbol;
        }

        return result;
    }

    /**
     * @param playSymbol          symbol returned by last move made : 0, 1 or -1
     * @param currentPlayerSymbol current player's symbol who played
     * @param game                actual game instance
     * @return the status of the game after current move Winner.Player1 if player1 is winner,
     * Winner.Player2 if player2 is winner else Winner.UNDECIDED
     */
    private Winner checkIfWinner(int playSymbol, int currentPlayerSymbol, TicTacToe game) {
        Winner result = Winner.UNDECIDED;

        if (playSymbol == currentPlayerSymbol) {
            if (game.currentPlayerP1) {
                result = Winner.PLAYER1;
            } else {
                result = Winner.PLAYER2;
            }
        }

        return result;
    }
}
