package com.swiggy.battleship.game;

import com.swiggy.battleship.person.Player;

import java.util.List;

/*
 * Abstract Factory class which returns concrete factory
 * */
public abstract class GameFactory {

    public static GameFactory getGameFactory(GameLevel level) {

        switch (level) {
            case Beginner:
                return new OneAttackPerChance();
            case Advanced:
                return new MultipleAttacksPerChance();
        }

        return null;
    }

    public abstract Game getGame(List<Player> playerList);
}
