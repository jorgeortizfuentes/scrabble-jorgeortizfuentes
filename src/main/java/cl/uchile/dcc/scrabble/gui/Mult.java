package cl.uchile.dcc.scrabble.gui;

public class Mult implements Operation {
  Operation left;
  Operation right;

  public Mult(Operation left, Operation right) {
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