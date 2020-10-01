package com.swiggy.battleship;

import com.swiggy.battleship.game.Game;
import com.swiggy.battleship.game.GameFactory;
import com.swiggy.battleship.game.GameLevel;
import com.swiggy.battleship.game.AttackResult;
import com.swiggy.battleship.board.Position;
import com.swiggy.battleship.person.Player;
import com.swiggy.battleship.ship.ShipOrientation;
import com.swiggy.battleship.ship.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class BattleShipGame {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

        //Step1: Define Players
        Player player1 = new Player.Builder("Chris", "CaptainAmerica").
                lastName("Evans").emailId("chris@gmail.com").
                build();

        Player player2 = new Player.Builder("Robert", "IronMan").
                lastName("Downey Jr").emailId("robert@gmail.com").
                build();
        System.out.println("player1 is - " + player1.getUsername());
        System.out.println("player2 is - " + player2.getUsername());

        //Step2: Init Game
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(player1);
        playerList.add(player2);

        GameFactory gameFactory = GameFactory.getGameFactory(GameLevel.Beginner);
        Game game = gameFactory.getGame(playerList);

        if (game == null)
            throw new Exception("Please provide correct details");

        //Step3: Place ships on board
        player1.placeShip(game, ShipType.Carrier, new Position('A', 1), ShipOrientation.Horizontal);
        player1.placeShip(game, ShipType.Submarine, new Position('B', 2), ShipOrientation.Horizontal);
        player1.placeShip(game, ShipType.Battleship, new Position('F', 5), ShipOrientation.Vertical);

        player2.placeShip(game, ShipType.Carrier, new Position('A', 1), ShipOrientation.Horizontal);
        player2.placeShip(game, ShipType.Submarine, new Position('C', 2), ShipOrientation.Horizontal);
        player2.placeShip(game, ShipType.Battleship, new Position('G', 5), ShipOrientation.Vertical);
        System.out.println("---------  Placing Ship on board completed ----------");


        //Step4: Start Game by taking input from user
        playGame(player1, player2, game);

        System.out.println("--------- Printing Player Stats ----------");
        player1.printStats();
        player2.printStats();
    }

    /*
     * Assumption : Game Implementation is OneAttackPerChance
     * */
    private static void playGame(Player player1, Player player2, Game game) {
        Pattern drawPattern = Pattern.compile("^Draw Board|d$");
        Pattern firePattern = Pattern.compile("^Fire ([A-J])([1-9]|10)$");
        Scanner in = new Scanner(System.in);
        Boolean player1Chance = true;
        while (true) {
            try {
                if (player1Chance) {
                    System.out.println("Player 1/CaptainAmerica Please enter input");
                } else {
                    System.out.println("Player 2/IronMan Please enter input");
                }

                String input = in.nextLine();
                String rowString, colString;
                System.out.println("received input - " + input);

                Matcher drawPatternMatcher = drawPattern.matcher(input);
                Matcher firePatterMatcher = firePattern.matcher(input);

                if (drawPatternMatcher.matches()) {
                    //printing board
                    System.out.println("Printing Board for Player 1/CaptainAmerica");
                    player1.printBoard(game);
                    System.out.println("Printing Board for Player 2/IronMan");
                    player2.printBoard(game);
                } else if (firePatterMatcher.matches()) {
                    rowString = firePatterMatcher.group(1);
                    colString = firePatterMatcher.group(2);

                    char row = rowString.charAt(0);
                    int col = Integer.parseInt(colString);
                    Position position = new Position(row, col);

                    AttackResult attackResult;
                    if (player1Chance) {
                        attackResult = player1.attack(game, position);
                    } else {
                        attackResult = player2.attack(game, position);
                    }

                    System.out.println("attackResult - " + attackResult);
                    if (attackResult == AttackResult.Win)
                        break;

                    if (attackResult != AttackResult.Invalid)
                        player1Chance = !player1Chance;
                    System.out.println();
                } else {
                    System.out.println("Invalid input. Please try again!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}




