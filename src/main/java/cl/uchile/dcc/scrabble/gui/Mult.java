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
    ScrabbleNumber multiplicant = (ScrabbleNumber) left.evaluate();
    ScrabbleNumber multiplicator = (ScrabbleNumber) right.evaluate();
    return (ScrabbleType) multiplicant.multiplyWith(multiplicator);
  }
}
