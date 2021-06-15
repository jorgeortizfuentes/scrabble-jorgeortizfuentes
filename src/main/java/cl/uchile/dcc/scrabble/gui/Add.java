package cl.uchile.dcc.scrabble.gui;

public class Add implements Operation {
  ScrabbleType left;
  ScrabbleType right;


  public Add(ScrabbleType left, ScrabbleType right) {
    this.left = left;
    this.right = right;
  }

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  @Override
  public ScrabbleType evaluate() {
    return null;
  }
}
