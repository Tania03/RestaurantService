package com.swiggy.battleship.person;

import com.swiggy.battleship.game.Game;
import com.swiggy.battleship.game.AttackResult;
import com.swiggy.battleship.board.Position;
import com.swiggy.battleship.ship.ShipOrientation;
import com.swiggy.battleship.ship.ShipType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
public class Player extends Person {

    Map<String, Game> gameHistory;

    /*
     * Using builder pattern here to enforce mandatory params and optional params constraint
     * */
    public static class Builder {
        private String firstName;
        private String lastName;
        private String username;
        private String emailId;

        //mandatory params are part of constructor
        public Builder(String firstName, String username) {
            this.firstName = firstName;
            this.username = username;
        }

        public Player build() {
            return new Player(this);
        }

        //optional params are defined as builder func
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        //optional params are defined as builder func
        public Builder emailId(String emailId) {
            this.emailId = emailId;
            return this;
        }
    }

    private Player(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.username = builder.username;
        this.accountStatus = AccountStatus.Active;
        this.createdAt = System.currentTimeMillis(); //use some datetime utils here
        this.gameHistory = new LinkedHashMap<String, Game>();

        //add permissions for player
        this.permissionsList.add(UserPermissions.CreateGame);
        this.permissionsList.add(UserPermissions.PlayGame);
    }

    public void addGame(Game game) {
        this.gameHistory.put(game.getId(), game);
    }

    public boolean placeShip(Game game, ShipType shipType, Position position, ShipOrientation orientation) {
        return game.placeShip(this, shipType, position, orientation);
    }

    public AttackResult attack(Game game, Position position) {
        return game.attackShip(this, position);
    }

    public void printBoard(Game game) {
        game.printBoard(this);
    }


    /**
     * Print All game statistics of player
     */
    public void printStats() {
        int winCount = 0;

        for (Game game : gameHistory.values()) {
            if (game.getWinnerPlayer().equals(this)) {
                winCount++;
            }
        }

        System.out.println("Player - " + username + " :: total games = " + gameHistory.size() + " & winCount = " + winCount);
    }


}
