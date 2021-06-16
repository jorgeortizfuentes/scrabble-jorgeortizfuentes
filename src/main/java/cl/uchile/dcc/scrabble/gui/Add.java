package cl.uchile.dcc.scrabble.gui;

public class Add implements Operation {
  Operation left;
  Operation right;


  public Add(Operation left, Operation right) {
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
    return left.evaluate().addWith(right.evaluate());
  }
}
