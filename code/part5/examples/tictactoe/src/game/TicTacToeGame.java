package game;

public class TicTacToeGame {
  private final int SIZE = 3;
  private Peg nextPeg = Peg.SECOND;
  private Peg[][] pegs = new Peg[SIZE][SIZE];

  public GameStatus getGameStatus() {
    if(gameWonByRowMatch()) {
      return GameStatus.WON;
    }

    return GameStatus.INPROGRESS;
  }

  private boolean gameWonByRowMatch() {
    for (int i = 0; i < SIZE; i++) {
      if(pegs[i][0] == pegs[i][1] && pegs[i][1] == pegs[i][2] && pegs[i][0] != Peg.EMPTY) {
        return true;
      }
    }

    return false;
  }

  public TicTacToeGame() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        pegs[i][j] = Peg.EMPTY;
      }
    }
  }

  public void placePeg(int row, int column) {
//    if(pegs[row][column] != Peg.EMPTY) {
//      throw new TicTacToeException("Position Occupied");
//    }
//
//    pegs[row][column] = nextPeg;
//    nextPeg = nextPeg == Peg.FIRST ? Peg.SECOND : Peg.FIRST;
// we applied SLAP, refactored using the extract method refactoring technique.

    validatePossitionIsEmpty(row, column);

    pegs[row][column] = nextPeg;

    toggleNextPeg();
  }

  private void validatePossitionIsEmpty(int row, int column) {
    if(pegs[row][column] != Peg.EMPTY) {
      throw new TicTacToeException("Position Occupied");
    }
  }

  private void toggleNextPeg() {
    nextPeg = nextPeg == Peg.FIRST ? Peg.SECOND : Peg.FIRST;
  }

  public Peg getPegAt(int row, int column) {
    return nextPeg;
  }
}
