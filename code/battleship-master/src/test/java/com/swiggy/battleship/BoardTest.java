package com.swiggy.battleship;

import com.swiggy.battleship.game.Game;
import com.swiggy.battleship.game.GameFactory;
import com.swiggy.battleship.game.GameLevel;
import com.swiggy.battleship.game.AttackResult;
import com.swiggy.battleship.board.Position;
import com.swiggy.battleship.person.Player;
import com.swiggy.battleship.ship.ShipOrientation;
import com.swiggy.battleship.ship.ShipType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testPlaceShips() {

        Player player1 = new Player.Builder("Chris", "CaptainAmerica").
                lastName("Evans").emailId("chris@gmail.com").
                build();

        Player player2 = new Player.Builder("Robert", "IronMan").
                lastName("Downey Jr").emailId("robert@gmail.com").
                build();

        //Step2: Init Game
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(player1);
        playerList.add(player2);

        GameFactory gameFactory = GameFactory.getGameFactory(GameLevel.Beginner);
        Game game = gameFactory.getGame(playerList);


        assertTrue(player1.placeShip(game, ShipType.Carrier, new Position('A', 1), ShipOrientation.Horizontal));
        assertFalse(player1.placeShip(game, ShipType.Carrier, new Position('A', 1), ShipOrientation.Horizontal));
        assertTrue(player1.placeShip(game, ShipType.Carrier, new Position('B', 1), ShipOrientation.Vertical));
        assertTrue(player1.placeShip(game, ShipType.Carrier, new Position('B', 2), ShipOrientation.Horizontal));
        assertFalse(player1.placeShip(game, ShipType.Carrier, new Position('J', 0), ShipOrientation.Horizontal));
        assertFalse(player1.placeShip(game, ShipType.Carrier, new Position('J', 7), ShipOrientation.Horizontal));
    }

    @Test
    public void testWinAndInvalidStates() {

        Player player1 = new Player.Builder("Chris", "CaptainAmerica").
                lastName("Evans").emailId("chris@gmail.com").
                build();

        Player player2 = new Player.Builder("Robert", "IronMan").
                lastName("Downey Jr").emailId("robert@gmail.com").
                build();

        //Step2: Init Game
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(player1);
        playerList.add(player2);

        GameFactory gameFactory = GameFactory.getGameFactory(GameLevel.Beginner);
        Game game = gameFactory.getGame(playerList);

        player1.placeShip(game, ShipType.Carrier, new Position('A', 1), ShipOrientation.Horizontal);

        assertEquals(player2.attack(game, new Position('B', 2)), AttackResult.Miss);
        assertEquals(player2.attack(game, new Position('Z', 2)), AttackResult.Invalid);

        assertEquals(player2.attack(game, new Position('A', 1)), AttackResult.Hit);
        assertEquals(player2.attack(game, new Position('A', 2)), AttackResult.Hit);
        assertEquals(player2.attack(game, new Position('A', 3)), AttackResult.Hit);
        assertEquals(player2.attack(game, new Position('A', 4)), AttackResult.Hit);
        assertEquals(player2.attack(game, new Position('A', 5)), AttackResult.Win);

        //invalid move as game is finished
        assertEquals(player2.attack(game, new Position('A', 5)), AttackResult.Invalid);
    }
}
