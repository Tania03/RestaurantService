package com.swiggy.battleship.game;

import com.swiggy.battleship.board.Board;
import com.swiggy.battleship.board.Position;
import com.swiggy.battleship.person.Player;
import com.swiggy.battleship.ship.Ship;
import com.swiggy.battleship.ship.ShipFactory;
import com.swiggy.battleship.ship.ShipOrientation;
import com.swiggy.battleship.ship.ShipType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 */
public abstract class Game {

    protected String id;
    protected GameStatus gameStatus;
    protected Player winnerPlayer;
    protected Map<Player, Board> boardByPlayer;
    protected Map<Player, List<Position>> moves;

    public Game() {
        gameStatus = GameStatus.Created;
        id = UUID.randomUUID().toString();
        winnerPlayer = null;
        boardByPlayer = new HashMap<Player, Board>();
        moves = new HashMap<Player, List<Position>>();
    }

    public String getId() {
        return id;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }


    /**
     * @param shipType
     * @param position
     * @param orientation
     * @return
     */
    private Ship createShip(ShipType shipType, Position position, ShipOrientation orientation) {

        Ship ship = ShipFactory.createShip(shipType);

        if (ship == null || position == null) {
            System.out.println("Invalid ship details provided");
            return null;
        }

        ship.setPosition(position);
        ship.setOrientation(orientation);
        return ship;
    }


    /**
     * @param player
     * @param shipType
     * @param position
     * @param orientation
     */
    public boolean placeShip(Player player, ShipType shipType, Position position, ShipOrientation orientation) {

        Ship ship = createShip(shipType, position, orientation);
        //Get board owned by current player
        Board board = boardByPlayer.get(player);
        //place ship on this board
        if (!board.isPlaceShipValid(ship)) {
            return false;
        }

        board.placeShip(ship);
        System.out.println(shipType + " ship is placed successfully on board!");

        if (gameStatus == GameStatus.Created)
            gameStatus = GameStatus.Ready;
        return true;
    }

    public abstract AttackResult attackShip(Player player, Position attackPos);


    /**
     * @param player
     */
    public void printBoard(Player player) {
        Board board = boardByPlayer.get(player);

        if (board == null) {
            System.out.println("No Board found for this player in this game");
            return;
        }

        board.print();
    }
}
