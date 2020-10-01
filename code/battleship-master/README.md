# Battleship
BattleShip Game 

This is a Java maven project.

Visit BattleShipGame class inside src/main/java

Requirements:

Code up the design for playing the BattleShip Game
(https://en.wikipedia.org/wiki/Battleship_(game)) for 2 people playing on the same computer
1. We will looking for the Low Level Design including good class structure, entities and
how they interact, good abstraction, good separation of concerns, etc
a. You need to at least represent the following entities:
i. Players who has many games
ii. Games which has a board
iii. Board which have ships
iv. Ships which can be sunk or afloat
2. You will need to code the “Game Loop” where the computer waits for the current
players input, once the user chooses what he wants to do, update the state of the
game (and check whether the player has won or lost) and then change the current
player.
3. You don’t need to bother with the code that “draws” the game or UI interactions, you
can mock the function for eg. “drawBoard(List<Ship> ships)” and assume it draws the
board with the ships on it. You can also assume an “takeInput(Player player)”
function that gets the play that the current player wishes to make.
a. Bonus: Take the input from the console. For eg. player can say “Fire C5” and
you fire a missile at C5 or “Draw Board” and you print the current state of the
board to the player.
4. You can choose any language, however, it needs to be a runnable code.

Rules of the Game:
  
1. Each Person has two boards, one where he places his own ships, one where he
tracks the missiles he has fired. Each board is of size 10x10
2. Each person can place 5 ships on his board
a. Carrier of length 5
b. Battleship of length 4
c. Cruiser of length 3
d. Submarine of length 3
e. Destroyer of length 2
3. Players take turn to fire missiles at the opposing player. If the missile hits a ship, then
the opposing player informs the initial mover of a hit , else he says it’s a miss . If all the
spots on a ship are hit, then ship is sunk.
4. The first player to sink all 5 ships of the opposing player wins the game.
This is the view of one player
1. Left hand side is the ships as placed by the player. Red spots represent where the
enemy successfully struck the player’s ships.
2. White/Green spots are where the enemy player missed.
3. The right hand side is where the player has launched missiles against the enemy.
4. The player has sunk 3 of the enemy ship
