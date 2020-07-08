package domain;

public class GuessGameLogic2 {
  private int theNumber;
  private int remainder = 5;
  private String hint;

  public GuessGameLogic2(int startNumber, int endNumber) {
    this.theNumber = generateRandomNumber(startNumber, endNumber);
  }

  public GuessGameLogic2(int startNumber, int endNumber, int remainder) {
    this(startNumber, endNumber);
    this.remainder = remainder;
  }

  public boolean isCorrectGuess(int guess) {
    if(guess == theNumber) {
      return true;
    } else {
      if(theNumber > guess) {
        setHint("Guess Number too SMALL");
      } else {
        setHint("Guess Number too BIG");
      }
      remainder--;
      return false;
    }
  }

  private int generateRandomNumber(int startNumber, int endNumber) {
    double range = (double)(endNumber - startNumber + 1);
    return startNumber + (int)(Math.random() * range);
  }

  public String getHint() {
    return hint;
  }

  public void setHint(String hint) {
    this.hint = hint;
  }

  public int getRemainder() {
    return remainder;
  }
}
