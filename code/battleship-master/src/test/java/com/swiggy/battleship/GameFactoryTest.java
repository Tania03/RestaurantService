package com.swiggy.battleship;

import com.swiggy.battleship.game.*;
import com.swiggy.battleship.person.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class GameFactoryTest {

    @Test
    public void testAbstractGameFactory() {
        GameFactory gameFactory1 = GameFactory.getGameFactory(GameLevel.Beginner);
        assertThat(gameFactory1, instanceOf(OneAttackPerChance.class));

        GameFactory gameFactory2 = GameFactory.getGameFactory(GameLevel.Advanced);
        assertThat(gameFactory2, instanceOf(MultipleAttacksPerChance.class));


        List<Player> playerList = new ArrayList<Player>();
        playerList.add(new Player.Builder("fn1", "us1").build());
        playerList.add(new Player.Builder("fn2", "us2").build());

        Game game1 = gameFactory1.getGame(playerList);
        assertThat(game1, instanceOf(TwoPlayerGame.class));
    }
}
