package com.swiggy.battleship.game;

import com.swiggy.battleship.person.Player;

import java.util.List;

public class OneAttackPerChance extends GameFactory {

    public Game getGame(List<Player> playerList) {

        switch (playerList.size()) {
            case 2:
                return new TwoPlayerGame(playerList.get(0), playerList.get(1));
        }

        return null;
    }
}
