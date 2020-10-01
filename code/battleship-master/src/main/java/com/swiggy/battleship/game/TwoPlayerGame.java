package com.swiggy.battleship.game;

import com.swiggy.battleship.models.Constants;
import com.swiggy.battleship.board.Board;
import com.swiggy.battleship.board.Position;
import com.swiggy.battleship.person.Player;

import java.util.ArrayList;
import java.util.Map;

public class TwoPlayerGame extends Game {

    Player player1;
    Player player2;

    /**
     * @param player1
     * @param player2
     */
    public TwoPlayerGame(Player player1, Player player2) {
        super();

        this.player1 = player1;
        this.player2 = player2;
        this.player1.addGame(this);
        this.player2.addGame(this);

        boardByPlayer.put(player1, new Board(Constants.BOARD_NUM_ROWS, Constants.BOARD_NUM_COLS));
        boardByPlayer.put(player2, new Board(Constants.BOARD_NUM_ROWS, Constants.BOARD_NUM_COLS));

        moves.put(player1, new ArrayList<Position>());
        moves.put(player2, new ArrayList<Position>());

        System.out.println("----------Game Init completed----------");
    }


    /**
     * @param player
     * @param attackPos
     * @return
     */
    public AttackResult attackShip(Player player, Position attackPos) {

        if (gameStatus != GameStatus.Ready) {
            System.out.println("invalid game status - " + gameStatus);
            return AttackResult.Invalid;
        }

        //log this move
        this.moves.get(player).add(attackPos);

        Player opponent = getOpponentPlayer(player);

        System.out.println("Attacking player " + opponent.getUsername() + " at pos " + attackPos + "!");

        Board opponentBoard = boardByPlayer.get(opponent);
        AttackResult result = opponentBoard.attack(attackPos);

        if (result != AttackResult.Invalid) {
            Board playerBoard = boardByPlayer.get(player);
            playerBoard.updateTargetBoard(attackPos, result);
        }

        //check If all ships in opponentBoard are sunk and game is finished
        if (result == AttackResult.Hit && opponentBoard.checkIfAllShipsSunk()) {
            winnerPlayer = player;
            gameStatus = GameStatus.Finished;
            return AttackResult.Win;
        }

        return result;
    }


    //in 2 player find first non matching player
    private Player getOpponentPlayer(Player p) {
        for (Map.Entry<Player, Board> entry : boardByPlayer.entrySet()) {
            if (!p.equals(entry.getKey())) {
                return entry.getKey();
            }
        }

        return null;
    }
}
