package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {
  private TicTacToeGame ticTacToeGame;

  @BeforeEach
  void init() {
    ticTacToeGame = new TicTacToeGame();
  }

  @Test
  void canary(){
    assertTrue(true);
  }

  @Test
  void gameInProgressAtStart(){
    //TicTacToeGame ticTacToeGame = new TicTacToeGame();

    //assertFalse(ticTacToeGame.isGameWon()); - but what about if the game is in progress vs. lost

    assertEquals(GameStatus.INPROGRESS, ticTacToeGame.getGameStatus());
  }

  @Test
  void placeTheFirstPegAtAnEmptyLocation(){
    //TicTacToeGame ticTacToeGame = new TicTacToeGame();

    //ticTacToeGame.placePeg(new Cell(1, 1), new Peg("X"));
    //once we write the above, let us ask "how does this feel" Simple or complex?

    //Do we really need a peg? Do we really need a Cell

    //ticTacToeGame.placePeg(1, 1, "X");
    //how does that feel compared to the previous one and also to move forward?
    //compared to the previous one: less effort, no need for two more classes. So, better.
    //Wait. If we ask the user to send "X", what if they pass a "W" which is invalid?
    //A poor design may need more validation and more tests. A better design will need
    //fewer validation and fewer tests.

    //Hey, we don't have to care about X, O, etc. What if the player wants to play a game
    //with not X and O, but chicken and goat. So, X or O is not necessary to be the values
    //of a peg. So, then what gives?

    //What if we create an enum that has EMPTY, FIRST, SECOND for the Peg. EMPTY is obvious,
    //FIRST is the peg placed by the first player, SECOND by the second player. We don't have to
    //care about X or O. More extensible design.

    ticTacToeGame.placePeg(1, 1);
    assertEquals(Peg.FIRST, ticTacToeGame.getPegAt(1, 1));
  }

  //what were we doing above? Writing test or something more?
  //It was an act of design

  @Test
  void placeTheSecondPegAtAnEmptyLocation(){
    ticTacToeGame.placePeg(1, 1);

    ticTacToeGame.placePeg(1, 2);

    assertEquals(Peg.SECOND, ticTacToeGame.getPegAt(1, 2));
  }

  @Test
  void placeAPegAtANonEmptyLocation(){
    ticTacToeGame.placePeg(1, 1);

    var ex = assertThrows(TicTacToeException.class, () -> ticTacToeGame.placePeg(1, 1));
    //we may ignore the move or throw an exception.

    assertEquals("Position Occupied", ex.getMessage());
  }

  @Test
  void checkGameWonOnRowMatch(){
    ticTacToeGame.placePeg(1, 1);
    ticTacToeGame.placePeg(2, 2);
    ticTacToeGame.placePeg(1, 0);
    ticTacToeGame.placePeg(2, 1);

    ticTacToeGame.placePeg(1, 2);

    assertEquals(GameStatus.WON, ticTacToeGame.getGameStatus());
  }

}
